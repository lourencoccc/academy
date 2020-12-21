
## chapter 2.1

degrees of freedom = (sum of freedoms of the bodies) −
(number of independent constraints).

### Pratice 1 - chapter 2.1

1. Which of the following are possible elements of robots in this specialization? Select all that apply.

* Rigid bodies.
* JoinQuestion 2

2. The number of degrees of freedom of a robot is (select all that apply):


* **T** the dimension of its configuration space.
* **T** the number of real numbers needed to specify its configuration.
* the number of points on the robot.
* the number of joints of the robot.
* the number of bodies comprising the robot.
* the number of freedoms of the bodies minus the number of independent constraints between the bodies.

3. The number of degrees of freedom of a planar rigid body is

* 3

4. The number of degrees of freedom of a spatial rigid body is

* 6

5. A rigid body in nn-dimensional space has mm total degrees of freedom. How many of these mm degrees of freedom are angular (not linear)?  Select all that apply.  (This is consistently one of the most incorrectly answered questions in this course, so think about it carefully!)

*  **m - n**
 `n` linear coordinates specify the location of one point of the rigid body, and the remaining `m-n` coordinates are subject to radius constraints (as described in the video), and hence can be thought of as angular coordinates.

* **n (n -1) / 2**

### Grubler's formula

dof =  m(N - 1 - J) + Sum(Fi)

* N: number oof links
* J: number of joints
* m: number of degrees of freedom (m = 3 for plana and m = 6 for spatial)
* Fi: be the number of freedoms provided by joint i

### Pratice 2 - Chapeter 2.2

1. Consider a joint between two rigid bodies. Each rigid body has `m` degrees of freedom (`m = 3` for a planar rigid body and `m=6` for a spatial rigid body) in the absence of any constraints. The joint has `f` degrees of freedom (e.g., `f = 1` for a revolute joint or `f = 3` for a spherical joint). How many constraints does the joint place on the motion of one rigid body relative to the other?  Write your answer as a mathematical expression in terms of `m` and  `f`.

* Since the second body only has ff freedoms relative to the first body, the joint must place `m - f` constraints on the mm motion freedoms of the second body.

2. Consider a mechanism consisting of three spatial rigid bodies (including ground, `N = 4`) and four joints: one revolute, one prismatic, one universal, and one spherical. According to Grubler's formula, how many degrees of freedom does the mechanism have?

* Correct
In Grubler's formula, `N=4,m=6,J=4`, and the sum of joint freedoms is `1+1+2+3=7`, giving `6(4−4−1)+7=1 dof`.

A mechanism that is incapable of motion has zero degrees of freedom. In some circumstances, Grubler's formula indicates that the number of degrees of freedom of a me

* The constraints implied by the joints must not be independent.


### Quiz 1


1. Using the methods for determining the number of degrees of freedom of a rigid body in 3-dimensional space from the book and the video, find the number of degrees of freedom of a rigid body in a conceptual 4-dimensional space.  Your answer should be an integer.

* 10

2. Referring back to Question 1, indicate how many of the total degrees of freedom are angular (rotational).  Your answer should be an integer.

* 6

The 4 coordinates to place the first point on the rigid body are translational (linear).  All other points are subject to distance constraints, which make them angular degrees of freedom.

3. Assume your arm, from your shoulder to your palm, has 7 degrees of freedom.  You are carrying a tray like a waiter, and you must keep the tray horizontal to avoid spilling drinks on the tray.  How many degrees of freedom does your arm have while satisfying the constraint that the tray stays horizontal?  Your answer should be an integer.

* 5

The requirement that the tray be horizontal places two constraints on its orientation:  the rotation of the tray about two axes defining the horizontal plane of the tray must be zero.  (In other words, the roll and the pitch of the tray are zero.)

4. Four identical SRS arms are grasping a common object as shown below.


Question 4
Four identical SRS arms are grasping a common object as shown below.   


Find the number of degrees of freedom of this system while the grippers hold the object rigidly (no relative motion between the object and the last links of the SRS arms).  Your answer should be an integer.

Hint:  When the grippers hold the object rigidly, the object plus the last links of each robot together act as a single rigid body (link).

* 10 

5. Referring back to Question 4, suppose there are now a total of `n` such arms grasping the object. What is the number of degrees of freedom of this system?  Your answer should be a mathematical expression including `n`.

* `n + 6`

6. Referring back to Question 4 and 5, suppose the revolute joint in each of the `n` arms is now replaced by a universal joint. What is the number of degrees of freedom of the overall system?

* `2n + 6`

7. Use the planar version of Grubler's formula to determine the number of degrees of freedom of the mechanism shown below.  Your answer should be an integer.  (Remember that a single joint can only connect two rigid bodies, so if you see more than two connecting at a single point, there must be more than one joint there.  Also, the two blocks in the channels are only allowed to move prismatically in those channels, and one of the joints is labeled "P" for prismatic.  You will need to identify all the other joints, and links.)

* `dof  = 3 * (8 - 1 - 9) + 9 => dof = -6 + 9 = 3`

