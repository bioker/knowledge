import sys
from PyQt4.QtGui import *

application = QApplication(sys.argv)

widget = QWidget()

widget.resize(320, 240)
widget.setWindowTitle("Hello, World!")
widget.show()

sys.exit(application.exec_())
