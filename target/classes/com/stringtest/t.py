
import os
names = ["Rami","Shahd" ,"Rawan", "Anas", "Suhail"] # names to be repeated number of times
current_working_directory = os.getcwd()

print(current_working_directory)
r = open("src/main/java/com/stringtest/test.txt","w")
r.flush()
num = 1000000
for i in range(num):
    r.write(names[i % len(names)] + "\n")

print(f"{num} names have been written to test.txt")