def weight(x):
    w=x[::-1][l-1:u][::-1]
    if w:return int(w)
    else:return 0
N=int(input())
arr=input().split()
i=1
while(True):
    tarr=list(arr)
    l=1+(4*(i-1));u=4*i
    arr=sorted(arr,key=weight)
    if arr==tarr:break
    print(*arr)
    i+=1
