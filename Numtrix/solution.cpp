#include<bits/stdc++.h>
using namespace std;
int main()
{
    long long int n,m,i,j;

    cin>>n>>m;

    long long int a[n][m];
 
    for(i=0;i<n;i++)
    {
        for(j=0;j<m;j++)
        {
 
            cin>>a[i][j];

        }
    }
 
 
    long long int ct=0;
 
    for(i=0;i<n;i++)
    {
        for(j=0;j<m;j++)
        {
            //left cell
            if(i-1>=0)
            {
                if(__gcd(a[i][j],a[i-1][j])==1)
                    continue;
            }
            //right cell
            if(i+1<n)
            {
                if(__gcd(a[i][j],a[i+1][j])==1)
                    continue;
            }
            //above cell
            if(j-1>=0)
            {
                if(__gcd(a[i][j],a[i][j-1])==1)
                    continue;
            }
            //below cell
            if(j+1<m)
            {
                if(__gcd(a[i][j],a[i][j+1])==1)
                    continue;
            }
            ct++;
        }
    }
 
    cout<<ct;
}