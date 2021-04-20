#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

vector<int> solution(int brown, int yellow)
{
    vector<int> answer;
    int size=brown + yellow;
    for (size_t i = 3; i <= 5000; i++)
    {
        for (size_t j = 3; j <= 5000; j++)
        {
            if(i*j==size&&2*i+2*j-4==brown){
                answer.push_back(i);
                answer.push_back(j);
                break;
            }
        }
        if(answer.size()==2){
            break;
        }
    }
    reverse(answer.begin(),answer.end());
    return answer;
}

int main()
{
    vector<int> temp=solution(10, 2);
    for (size_t i = 0; i < temp.size(); i++)
    {
        cout<<temp.at(i);
    }
    
    return 0;
}
