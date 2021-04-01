#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
#include <functional>
#include <map>
using namespace std;

int solution(vector<vector<string>> clothes)
{
    map<string, int> arr;
    int answer = 1;

    for (auto cloth : clothes)
    {
        arr[cloth[1]]++;
    }
    for (auto i = arr.begin(); i != arr.end(); i++)
    {
        answer *= i->second + 1;
    }

    return answer - 1;
}
int main()
{
    cout << solution({{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}});
}