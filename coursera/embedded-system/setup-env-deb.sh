#!/bin/sh

apt-get update
dpkg --add-architecture i386
apt-get update
apt-get install git -y
apt-get install util-linux -y
apt-get install htop -y
apt-get install zsh -y
apt-get install zip -y
apt-get install curl -y
apt-get install dkms -y
apt-get install sudo -y
apt-get install net-tools -y
apt-get instlal openssh-server -y
apt-get install apt-transport-https -y
apt-get install vim -y
apt-get install tmux -y
apt-get install linux-headers-$(uname -r) -y
apt-get install build-essential -y
apt-get install gcc-arm-none-eabi -y