#include<bits/stdc++.h>
using namespace std;
long long int n;

//visited nodes
long long int vis[100005]={0};

//value of node
long long int values[100005];

//answer for a node
long long int ans[100005]={0};
vector<long long int> v[100005];
 
void dfs(long long int node)
{
    vis[node]=1;

    //if node has negative value add it to ans[node]
    if(values[node]==-1)
        ans[node]++;
 
    long long int si=v[node].size(),i;
 
    for(i=0;i<si;i++)
    {
        if(vis[v[node][i]]==0)
        {
            dfs(v[node][i]);
            //adding negative nodes of childern
            ans[node]+=ans[v[node][i]];
        }
    }
 
}
 
int main()
{

 
    cin>>n;
    long long int i;
    for(i=1;i<=n;i++)
        cin>>values[i];
 
    for(i=1;i<n;i++)
    {
        long long int x,y;
        cin>>x>>y;
        v[x].push_back(y);
        v[y].push_back(x);
    }
 
    dfs(1);
 
    for(i=1;i<=n;i++)
        cout<<ans[i]<<" ";
}