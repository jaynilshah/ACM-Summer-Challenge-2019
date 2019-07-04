n, k = input().split()
n = int(n)
k = int(k)
 
postmax = []
str_arr = input().split()
arr = [int(num) for num in str_arr]
for i in range(n-2,-1,-1):
    postmax.append(0)
postmax.append(-1)
for i in range(n-2,-1,-1):
    postmax[i]=(max(postmax[i+1],arr[i+1]))
 
ans =0
for i in range(n-1):
    ans = max(k*(postmax[i]-arr[i]),ans)
print(ans)

