#include<bits/stdc++.h>
using namespace std;
int main()
{
   
 
	long long int n;
	cin>>n;
	string s;
	cin>>s;
	long long int sum=0,i;
    
    //Add sum of digits of number
	for(i=0;i<n;i++)
    {
        sum+=s[i]-'0';
    }
 
    if(sum%3==0)
    {
        cout<<"YES";
    }
    else
    {
        cout<<"NO";
    }
 
    return 0;
}