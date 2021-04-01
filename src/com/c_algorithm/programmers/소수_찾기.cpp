#include <string>
#include <vector>
#include <iostream>
#include <functional>
#include <algorithm>
#include <set>
#include <cmath>

using namespace std;
int checkPrime(int n)
{
    if (n == 0 || n == 1)
        return 0;
    for (int i = 2; i <= sqrt(n); i++)
    {
        if (n % i == 0)
            return 0;
    }
    return 1;
}
int solution(string numbers)
{
    int answer = 0;
    set<int> arr;
    int temp = 0;
    sort(numbers.begin(), numbers.end());
    do
    {
        for (size_t i = 1; i < numbers.size() + 1; i++)
        {
            temp = stoi(numbers.substr(0, i));
            if (checkPrime(temp))
                arr.insert(temp);
        }

    } while (next_permutation(numbers.begin(), numbers.end()));
    answer = arr.size();
    return answer;
}
int main()
{
    cout << solution("17");
    return 0;
}