n = input()
x = raw_input()
 
r=0
b=0
for i in x:
    if i == "R":
        r=r+1
    else:
        b=b+1
        
count =0
for i in x:
    if i=="R":
        r=r-1
    else:
        b=b-1
    count=count+1
    if r==0 :
        break
    if b==0 :
        break
    
print(count)
