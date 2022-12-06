#!/usr/bin/env python3

import requests
import datetime
import sys
import os
import shutil

JAVAPATH=os.path.join('src','Days')

def getInput(day):
    cookie="asdf"
    print('Getting input.txt for Day '+day)
    requests.get('https://adventofcode.com/2022/day/'+day+'/input', cookies=cookie)

def createNewDay(day):
    print('Creating Day '+ str(day))
    dirpath=os.path.join(JAVAPATH,"Day"+str(day))
    if os.path.isdir(dirpath):
        response=input("Directory for Day "+str(day)+" already exists, would you like to overwrite it? [y/N]")
        if response!='y':
            print('Deciding against it')
            return
        else: 
            print('Overwriting ...')
            shutil.rmtree(dirpath)
    os.makedirs(dirpath)

def getDateSuffix(date):
    date_suffix = ["th", "st", "nd", "rd"]
    if date % 10 in [1, 2, 3] and date not in [11, 12, 13]:
        return date_suffix[date % 10]
    else:
        return date_suffix[0]

def getMonthName(month_num):
    return datetime.datetime.strptime(month_num, "%m").strftime("%B")

def getCurrentDay():
    date = datetime.datetime.now()
    print('Today is '+str(date.day)+getDateSuffix(date.day)+' of '+getMonthName(str(date.month)))
    if date.month != 12:
        print('You are not in December, there should not be AdventOfCode')
        return 0
    if date.day > 25:
        print('AdventOfCode should already be over')
        return 0
    return date.day

def main():
    day=getCurrentDay()
    if len(sys.argv) < 1:
        createNewDay(day)
        return
    print(sys.argv[1]+" was given as first argument")
    createNewDay(int(sys.argv[1]))
    

if __name__=='__main__':
    main()