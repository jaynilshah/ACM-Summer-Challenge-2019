q = int(input())
nax = 100005
mod = 1000000007
 
dp = [0 for i in range(nax)]
dp[1] = 1
dp[2] = 3
for i in range(3, nax):
	dp[i] = (dp[i-1]%mod + (2*dp[i-2])%mod)%mod
	
for i in range(0, q):
	n = int(input())
	print(dp[n])
