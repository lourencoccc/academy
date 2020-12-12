#!/bin/sh

#Check Python 
if which python3 > /dev/null 2>&1;
then
    py_version=`python3 --version 2>&1 | awk '{print $2}'`
    echo ":) - Python version $py_version is installed."
else
    echo ":( - Python is not installed"
    echo "Try to isntall using it: sudo apt-get install python3"
    exit
fi

#Create virtual enviroment
venv_dir=./.venv

if [ ! -d "$venv_dir" ]; then
    mkdir -p $venv_dir
    echo "Created Virtual Enviroment folder: $venv_dir"
    python3 -m venv $venv_dir
else
    echo "Virtual Enviroment folder: $venv_dir"
    if [ -f "$venv_dir/bin/activate" ]; then
        source $venv_dir/bin/activate
    fi
fi
