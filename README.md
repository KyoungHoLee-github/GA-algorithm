# GA-algorithm  
유전자 알고리즘(Genetic Algorithtm)은 다윈의 진화론으로부터 창안된 해 탐색 알고리즘이다.  
이 알고리즘은 다음 세대의 자손을 낳기 위해 가장 적합한 개체들이 번식 대상으로 선택되는 `자연 선택`의 과정을 반영한다.  

## 자연선택  
자연선택은 모집단에서 가장 적합한 후보를 선택하는 것으로부터 시작한다.  
선택된 후보는 부모의 특성을 이어받아 다음 세대의 자손을 낳고, 이어받은 자손들이 부모보다 더 좋은 적합도를 가진다면 다음 세대에도 이어지는 기회를 갖게 된다.  
이 과정을 계속해서 반복하고 결국 가장 적합한 후보해를 가지게 된다.  
유전 알고리즘의 자연선택에는 `초기 모집단`, `적합도`, `선택`, `교차`, `돌연변이`가 고려된다.  

## 초기 모집단  
모집단이라고 불리는 개체 집합이다.  
개체는 유전자 변수들의 집합으로 구성되는데 유전 알고리즘에서는 개인의 유전자 집합은 이진수 값(0과 1)로 구성되어 사용한다.  
![](https://user-images.githubusercontent.com/101320758/174012679-c9596985-f50f-44a0-ab38-7f45624c4a2d.png)

## 적합도  
적합도는 각각의 후보가 얼마나 적합한지를 보여준다.  
각각의 후보에는 적합도 점수가 있으며 다음 세대로 이어질 확률은 이 적합도 점수에 근거하여 동작한다.  

## 선택  
선택 단계에서는 가장 적합한 후보를 선택하고 다음 세대에 선택된 후보들을 물려주게 된다.  

## 교차  
교차 연산은 교차점을 임의로 정하여 교차점을 기준으로 서로 값들을 교환하여 선택 연산을 통해 얻은 후보보다 더 우수한 후보를 생성하기 위해 수행한다.  
!

## 돌연변이  
교차 연산이 수행된 후에 실행하며 어떠한 확률에 의해 후보해의 읿부분을 임의로 변경(0을 1로 또는 1을 0으로)시킨다.  
돌연변이 연산은 수행된 후에 후보해의 적합도가 좋아질수도 나빠질 수도 있다.  
돌연변이 연산의 경우에는 다음세대에 돌연변이 연산이 된 후보와 교차연산되어 이후 세대에서 더 좋은 후보해를 생성하려는데 의의가 있다.  
