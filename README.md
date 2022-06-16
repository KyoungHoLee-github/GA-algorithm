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
