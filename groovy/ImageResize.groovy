#!/usr/bin/env groovy

if (args.size() == 0){ 
    System.err.println('Image Resizer')
    System.err.println('Parameters: method mode newWidth newHight')
    System.err.println("Method variants: \'AUTOMATIC\' \'BALANCED\' \'QUALITY\' \'SPEED\' \'ULTRA_QUALITY\'")
    System.err.println("Mode variants: \'AUTOMATIC\' \'FIT_EXACT\' \'FIT_TO_HEIGHT\' \'FIT_TO_WIDTH\'")
    System.exit(0)
}

if (args.size() != 4){ 
    throw new Exception("invalid parameters count, use: method mode newWidth newHight")
}

String methodArg    = args[0]
String modeArg      = args[1]
String newWidthArg  = args[2]
String newHeightArg = args[3]

@Grab(group='org.imgscalr', module='imgscalr-lib', version='4.2')
import org.imgscalr.Scalr
import java.awt.image.BufferedImage
import javax.imageio.ImageIO

def resizeImage = { BufferedImage image, Scalr.Method method, Scalr.Mode mode, 
                    int newWidth, int newHeight ->

    int originalWidth = image.getWidth()
    int originalHeight = image.getHeight()

    System.err.println('original width: ' + originalWidth)
    System.err.println('original height: ' + originalHeight)

    return Scalr.resize(image, method, mode, newWidth, newHeight);
}

BufferedImage image = ImageIO.read(System.in)
BufferedImage resizedImage = resizeImage(image, Scalr.Method.valueOf(methodArg), 
    Scalr.Mode.valueOf(modeArg), Integer.valueOf(newWidthArg), Integer.valueOf(newHeightArg))

int resultWidth = resizedImage.getWidth()
int resultHeight = resizedImage.getHeight()

System.err.println('result width: ' + resultWidth)
System.err.println('result height: ' + resultHeight)

ImageIO.write(resizedImage, "png", System.out)
