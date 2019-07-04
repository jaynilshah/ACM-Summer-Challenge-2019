#include<bits/stdc++.h>
using namespace std;
#define ll long long
#define mod 1000000007
#define inf 100000000000000

int main() {
	//freopen("in03.txt", "r", stdin);
	//freopen("out03.txt", "w", stdout);
    ll n;
    cin>>n;
    
    string temp[n];
    
    for(int i=0;i<n;i++)
    cin>>temp[i];
    
    stack<char> sopen[n];
    stack<char> sclose[n];
    
    bool invalid[n];
    
    memset(invalid,false,sizeof(invalid));
    
    for(int i=0;i<n;i++) {
        
        int len = temp[i].size();
        for(int j=0;j<len;j++) {
            if(temp[i][j] == '(')
                sopen[i].push(temp[i][j]);
            else if(sopen[i].size()>0)
                sopen[i].pop();
        }
        
        for(int j=len-1;j>=0;j--) {
            if(temp[i][j] == ')')
                sclose[i].push(temp[i][j]);
            else if(sclose[i].size()>0)
                sclose[i].pop();
        }
        
    }
    
    ll oc[n][2];
    
    for(int i=0;i<n;i++) {
        oc[i][0] = sopen[i].size();
        oc[i][1] = sclose[i].size();
    }
    
    map <ll,ll> freqopen;
    map <ll,ll> freqclose;
    int freqzero = 0;
    
    
    for(int i=0;i<n;i++) {
        if(oc[i][0]!=0 && oc[i][1]!=0)
        continue;
        
        if(oc[i][0] == 0 && oc[i][1] == 0) {
            freqzero++;
            continue;
        }
        
        if(oc[i][0]==0)
        freqclose[oc[i][1]]++;
        else
        freqopen[oc[i][0]]++;
    }
    
    ll ans=0;
    
    
    for(int i=0;i<n;i++) {
        if(oc[i][0]!=0 && oc[i][1]!=0)
        continue;
        
        if(oc[i][0] == 0 && oc[i][1] == 0)
        continue;
        
        if(oc[i][0]!=0 && freqopen[oc[i][0]]>0) {
            if(freqclose[oc[i][0]]>0) {
                ans++;
                freqclose[oc[i][0]]--;
                freqopen[oc[i][0]]--;
            }
        }
        else if(oc[i][1]!=0 && freqclose[oc[i][1]]>0) {
            if(freqopen[oc[i][1]]>0) {
                ans++;
                freqclose[oc[i][1]]--;
                freqopen[oc[i][1]]--;
            }
        }
        
    }
    
    ans+=(freqzero/2);
    cout<<ans<<endl;
    return 0;
}
