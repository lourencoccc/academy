

http://hades.mech.northwestern.edu/index.php/Coursera_Resources

http://hades.mech.northwestern.edu/index.php/Modern_Robotics


## Ambiente de Desenvolvimento

Para resulução das questões do trabalho são utilizados as seguintes ferramentas e APIs:

* Python >= 3.7
* Jupyter
* ...

### Configuração

**Linux Debian\Ubuntu**

```bash
source setupenv.sh #Ativar o ambiente virtual
pip install -U pip #Atualizando ultima versão do pip
pip install numpy #Instalando numpy
pip install modern_robotics #modern_robotics https://github.com/NxRLab/ModernRobotics/tree/master/packages/Python
pip install jupyter #Instalando jupyter
```

**Windows 10**
    
```powershell
./setupenv.ps1
python.exe -m pip install --upgrade pip   #Atualizando ultima versão do pip
python.exe -m pip install jupyter #Instalando jupyter
```

import numpy as np
import modern_robotics as mr
se3mat = np.array([[0, 0, 0, 0], [0, 0, -1.5708, 2.3562], [0, 1.5708, 0, 2.3562], [0, 0, 0, 0]]); T = mr.MatrixExp6(se3mat)



sudo apt-get install libavcodec-dev libavformat-dev libswscale-dev
if above fails, try first:
sudo apt-get -f install