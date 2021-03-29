#include <string>
#include <vector>
#include <iostream>

using namespace std;

vector<int> solution(int n)
{
    vector<int> answer;
    int arr[n][n];
    int num = 0;
    for (size_t i = 1; i <= n; i++)
    {
        num += i;
    }
    int cnt = 0;
    int x1 = 0;
    int y1 = 0;
    int x2 = n;
    int y2 = n;
    int number = 1;
    while (cnt < n)
    {

        for (size_t i = x1; i < x2; i++)
        {
            arr[i][y1] = number++;
        }

        x1++;
        y1++;
        cnt++;
        if (cnt == n)
        {
            break;
        }
        for (size_t j = y1; j < y2; j++)
        {
            arr[x2 - 1][j] = number++;
        }
        x2--;
        cnt++;
        y2--;
        if (cnt == n)
        {
            break;
        }
        int temp = y2 - 1;
        for (size_t i = x2 - 1; i >= x1; i--)
        {
            arr[i][temp--] = number++;
        }
        x1++;
        y2--;
        cnt++;
        if (cnt == n)
        {
            break;
        }
    }
    for (size_t i = 0; i < n; i++)
    {
        for (size_t j = 0; j <= i; j++)
        {
            answer.push_back(arr[i][j]);
        }
    }

    return answer;
}

int main()
{
    solution(6);
    return 0;
}