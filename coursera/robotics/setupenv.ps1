#Python
$PythonHome="D:\Apps\Python\Python37"

$venv_dir="$HOME\pyvenv\icavenv"

$ActivateVenvCommand = "$venv_dir\Scripts\Activate.ps1"

if (Test-Path $ActivateVenvCommand) {
    & $ActivateVenvCommand
    Break
}

if (-Not (Test-Path $venv_dir)) {
    New-Item -ItemType Directory -Force -Path $venv_dir
} else {
    Write-Output "Virtual Enviroment folder found: $venv_dir"
}

$Command = "$PythonHome\python.exe"

& $Command "-m" "venv" $venv_dir

& $ActivateVenvCommand

