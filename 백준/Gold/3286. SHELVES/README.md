# [Gold V] SHELVES - 3286 

[문제 링크](https://www.acmicpc.net/problem/3286) 

### 성능 요약

메모리: 11596 KB, 시간: 72 ms

### 분류

다이나믹 프로그래밍

### 제출 일자

2025년 3월 26일 18:34:27

### 문제 설명

<p>A rack in a police department consists of shelves that are organised in C columns and R rows.</p>

<p>To reach an object from any shelf, a ladder must be used. A ladder can be leaned against one column of shelves only. By climbing the ladder to a certain height (row) it is possible to take any object from that column up to climbed height including any object from adjacent (left and right) columns.</p>

<p>Policemen need to take certain objects from the rack. To lower a risk of injury at work, it is necessary to find a way to take all needed objects from the rack so that total height of all climbing is minimal possible. Total height is a sum of heights of all climbings.</p>

<p>A rack with some object lying on its shelves is given.</p>

<p>Write a program that will determine minimal possible total height of climbings needed to collect all the objects from the rack.</p>

### 입력 

 <p>The first line of input file contains two integers C and R, 1 ≤ C ≤ 100, 1 ≤ R ≤ 100, number of columns and number of rows, separated by a space character.</p>

<p>The second line of input file contains an integer N, 1 ≤ N ≤ 100, number of shelves that needs to be reached.</p>

<p>Every of next N lines contains two integers A and B, 1 ≤ A ≤ C, 1 ≤ B ≤ R, separated by a space character, number of column and a row of a shelf that need to be reached.</p>

### 출력 

 <p>The first and only line of output file should contain minimal possible total height of climbings needed to reach all given shelves.</p>

