m = input().strip().split()

month = m[0]
day = int(m[1][:-1])
year = int(m[2])
hh, mm = map(int, m[3].split(':'))

names = ["January","February","March","April","May","June",
         "July","August","September","October","November","December"]
mi = names.index(month)

leap = (year%400==0) or (year%4==0 and year%100!=0)
mdays = [31, 29 if leap else 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]

total_minutes = (366 if leap else 365) * 24 * 60
passed_days = sum(mdays[:mi]) + (day - 1)
passed_minutes = passed_days * 24 * 60 + hh * 60 + mm

ans = passed_minutes * 100.0 / total_minutes
print(ans)
