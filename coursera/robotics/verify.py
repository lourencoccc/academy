import modern_robotics as mr
import numpy as np

R = np.array([[0, 0, 1],
              [1, 0, 0],
              [0, 1, 0]])
invR = mr.RotInv(R)

print(invR)


se3mat = np.array([
    [0, 0, 0, 0],
    [0, 0, -1.5708, 2.3562],
    [0, 1.5708, 0, 2.3562],
    [0, 0, 0, 0]
])

T = mr.MatrixExp6(se3mat)

print(np.around(T, 5))