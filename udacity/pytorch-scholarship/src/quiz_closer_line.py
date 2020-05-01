



def calcNewLine(line, point, learning_rate=0.1):
    new_line = {
        'w1':(line['w1'] + point[0] * learning_rate), 
        'w2':(line['w2'] + point[1] * learning_rate), 
        'bias':(line['bias'] + 1 * learning_rate)
    }
    return new_line

def applyLine(line, point):
    result =  line['w1'] * point[0] + line['w2'] * point[1] + line['bias']
    return result


line = {'w1':3, 'w2':4, 'bias':-10}
point = [1,1]
steps = 0
line = calcNewLine(line, point)
regionHasPoint = applyLine(line, point) > 0

while not regionHasPoint:    
    line = calcNewLine(line, point)
    print(line)
    result = applyLine(line, point)
    print(result)
    regionHasPoint = result > 0
    print(regionHasPoint)
    steps += 1

print(steps)






