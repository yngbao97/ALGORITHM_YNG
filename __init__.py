##########
## Create folders
import os 

## Date

# exams
exams = ['IM', 'IM_prep', 'A', 'A_prep', 'QUEUE', 'STACK', 'LINKED_LIST', 'TREE']

# 설날, 삼일절 
events = ['NY1', 'NY2', 'NY3', 'NY4', 'Independence_Movement_Day_0301']

# practice, 26 days 
days = [i  for i in range(2, 5)] 

# total = exams + events + days
total = days

# print(total) # double check


for t in total:
    # exams, events
    if type(t) is str:
        os.system(f'mkdir {t}')
        os.chdir(f'{t}')

    # days
    else:
        day = str()
        # single
        if t <=9:
            day = '0' + str(t)

        # double
        else:
            day = str(t)
            
        os.system(f'mkdir 2404{day}')
        os.chdir(f'2404{day}')
        
    os.system(f'touch .gitkeep')
    os.chdir('..')