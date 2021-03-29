#include <string>
#include <vector>
#include <iostream>
using namespace std;

vector<int> solution() {
    vector<int> prices;
    prices.push_back(1);
    prices.push_back(2);
    prices.push_back(3);
    prices.push_back(2);
    prices.push_back(3);
    vector<int> answer;

    for (size_t i = 0; i < prices.size(); i++)
    {
        int num = prices.at(i);
        if(i==prices.size()-1){
            answer.push_back(0);
        }else{
            int n = 0;
            for (size_t j = i+1; j < prices.size(); j++)
            {
                if(num>prices.at(j)){
                    n++;
                    break;
                }else{
                    n++;
                }
            }
            answer.push_back(n);
        }
        
    }
    return answer;
}

int main(){
    solution();
    return 0;
}