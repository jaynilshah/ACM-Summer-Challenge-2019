n = input()
for i in range(n):
    x=n-1
    start = i+1
    for j in range(i+1):
        print(start),
        
        start = start + x
        x= x-1
    print("\n")
