import heapq
import csv

jcnt = 0
jobs = []
completion_time = 0
ct_sum = 0

def sum_w_completion_time():
    global completion_time, ct_sum
    while jobs:
        ratio, weight, length = heapq.heappop(jobs)
        completion_time += length
        ct_sum += completion_time * weight
    return ct_sum

def read_schedule(filename):
    global jobs, jcnt
    tsv = csv.reader(open(filename), delimiter=' ')
    # jobs counts
    jcnt = tsv.next()
    # build heap
    for job in tsv:
        weight, length = int(job[0]), int(job[1])
        heapq.heappush(jobs, (-(weight / (length * 1.0)), weight, length))

def test():
    read_schedule("jobs.txt")

test()

print sum_w_completion_time()
