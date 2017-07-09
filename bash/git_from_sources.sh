sudo apt-get -y install autoconf
cd ~
git clone https://github.com/git/git.git
cd git
make configure
./configure --prefix=/usr --with-curl
make all
sudo make install
cd ..
rm -rf git
