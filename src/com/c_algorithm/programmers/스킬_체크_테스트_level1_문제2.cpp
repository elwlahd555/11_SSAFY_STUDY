#include <string>
#include <vector>
#include <iostream>
#include <functional>
#include <algorithm>
#include <unordered_map>

using namespace std;

vector<int> solution(vector<int> numbers) {
    vector<int> answer;
    for (size_t i = 0; i < numbers.size(); i++)
    {
        for (size_t j = i+1; j < numbers.size(); j++)
        {
            answer.push_back(numbers.at(i)+numbers.at(j));
        }
        
    }
    sort(answer.begin(),answer.end());
    answer.erase(unique(answer.begin(),answer.end()),answer.end());
    return answer;
}
int main(){
    vector<int> answer=solution({2,1,3,4,1});
    for (size_t i = 0; i < answer.size(); i++)
    {
        cout<<answer.at(i)<<endl;
    }
    
    return 0;
}