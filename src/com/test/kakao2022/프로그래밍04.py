import itertools
def solution(n, info):
    arr=[0,1,2,3,4,5,6,7,8,9,10]
    answer = [-1]
    per_list=list(set(itertools.product(arr,repeat=n)))
    max=0
    for i in per_list:
        temp=0
        row=[0 for k in range(11)]
        for j in i:
            row[j]+=1

        for j in range(len(arr)):
            if info[j]!=0 and info[j]>=row[j]:
                temp-=10-j
            elif row[j]>info[j]:
                temp+=10-j
        if temp>max:
            max=temp
            answer=row

    return answer


print(solution(5,[2,1,1,1,0,0,0,0,0,0,0]))
