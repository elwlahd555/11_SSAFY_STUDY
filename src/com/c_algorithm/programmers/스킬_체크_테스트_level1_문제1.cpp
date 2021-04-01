#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
#include <functional>
#include <unordered_map>

using namespace std;

int solution(int num) {
    int answer = 0;
    while(answer<=500){
        if(num%2==0){
            num/=2;
        }else if(num==1){
            break;
        }else if(num%2==1){
            num*=3;
            num++;

        }
        answer++;

    }
    if(answer>500){
        answer=-1;
    }
    return answer;
}
int main(){
    cout<<solution(626331)<<endl;
    return 0;
}