# GA-algorithm  
유전자 알고리즘(Genetic Algorithtm)은 다윈의 진화론으로부터 창안된 해 탐색 알고리즘이다.  
이 알고리즘은 다음 세대의 자손을 낳기 위해 가장 적합한 개체들이 번식 대상으로 선택되는 `자연 선택`의 과정을 반영한다.  

### 자연선택  
자연선택은 모집단에서 가장 적합한 후보를 선택하는 것으로부터 시작한다.  
선택된 후보는 부모의 특성을 이어받아 다음 세대의 자손을 낳고, 이어받은 자손들이 부모보다 더 좋은 적합도를 가진다면 다음 세대에도 이어지는 기회를 갖게 된다.  
이 과정을 계속해서 반복하고 결국 가장 적합한 후보해를 가지게 된다.  
유전 알고리즘의 자연선택에는 `초기 모집단`, `적합도`, `선택`, `교차`, `돌연변이`가 고려된다.  

### 초기 모집단  
모집단이라고 불리는 개체 집합이다.  
개체는 유전자 변수들의 집합으로 구성되는데 유전 알고리즘에서는 개인의 유전자 집합은 이진수 값(0과 1)로 구성되어 사용한다.  
![](https://user-images.githubusercontent.com/101320758/174012679-c9596985-f50f-44a0-ab38-7f45624c4a2d.png)

### 적합도  
적합도는 각각의 후보가 얼마나 적합한지를 보여준다.  
각각의 후보에는 적합도 점수가 있으며 다음 세대로 이어질 확률은 이 적합도 점수에 근거하여 동작한다.  

### 선택  
선택 단계에서는 가장 적합한 후보를 선택하고 다음 세대에 선택된 후보들을 물려주게 된다.  

### 교차  
교차 연산은 교차점을 임의로 정하여 교차점을 기준으로 서로 값들을 교환하여 선택 연산을 통해 얻은 후보보다 더 우수한 후보를 생성하기 위해 수행한다.  
![](https://user-images.githubusercontent.com/101320758/174017657-9fe1e456-27bb-4b48-aed9-fef1a4fd2458.png)

### 돌연변이  
교차 연산이 수행된 후에 실행하며 어떠한 확률에 의해 후보해의 읿부분을 임의로 변경(0을 1로 또는 1을 0으로)시킨다.  
돌연변이 연산은 수행된 후에 후보해의 적합도가 좋아질수도 나빠질 수도 있다.  
돌연변이 연산의 경우에는 다음세대에 돌연변이 연산이 된 후보와 교차연산되어 이후 세대에서 더 좋은 후보해를 생성하려는데 의의가 있다.  
코드에서 돌연변이가 일어날 확률은 `if`문과 랜덤변수의 값을 이용하여 구현하였다.  
![](https://user-images.githubusercontent.com/101320758/174017675-971a9310-92f2-4e26-9ef0-e8d9fb1d8731.png)

### 종료  
알고리즘이 최적해를 찾을경우 종료된다.  

### 실행결과  
![](https://user-images.githubusercontent.com/101320758/174021654-c2a2e66d-c8e5-456e-9771-36c09d61e580.png)  
![](https://user-images.githubusercontent.com/101320758/174021694-5eb41689-7795-459c-ab58-3fb5211cfbf0.png)  

# 회귀
독립 변수 x를 사용해서 종속 변수 y의 움직임을 예측하고 설명하는 작업  
x는 하나가 아니라 여러 개일 수 있는데 하나의 x값으로 y값을 설명할 수 있을 때 이를 단순 선형 회귀, 여러개가 필요할 때는 다중 선형 회귀라 한다.  
일차 함수 그래프 (y=ax+b)
![](https://camo.githubusercontent.com/2881d6505016186b5b4c845aafc0ad1dca27f5b7055490ac76875541ad666c42/68747470733a2f2f696d67312e6461756d63646e2e6e65742f7468756d622f523132383078302f3f73636f64653d6d746973746f72793226666e616d653d6874747073253341253246253246626c6f672e6b616b616f63646e2e6e6574253246646e253246636d6d577a75253246627471304472444357586d253246576b4e36456f535a7948357238716b68614b5074636b253246696d672e706e67)  
여기서 x값은 독립 변수이고 y값은 종속 변수이고 정확하계 계산하기 위해서는 상수 a, b 값을 알아야하는데 선형회귀는 정확한 직선을 그려내는 과정이기 때문에 최적의 a, b 값을 찾아내는 작업이라고 할 수 있다.  

### 최소제곱법  
측정값을 기초로 해서 적당한 제곱합을 만들고 그것을 최소로 하는 값을 구하는 방법  
![](https://camo.githubusercontent.com/778aee7339a19f178057601d7c7f4fc0136b44a28c6fde29379e235c46bf1913/68747470733a2f2f696d67312e6461756d63646e2e6e65742f7468756d622f523132383078302f3f73636f64653d6d746973746f72793226666e616d653d6874747073253341253246253246626c6f672e6b616b616f63646e2e6e6574253246646e253246625275436e6c2532466274713041346131354b54253246737443754f73736a684938616969446c783153577331253246696d672e706e67)  
이 최소제곱법을 이용하여 일차함수의 기울기 a값과 y절편 b값을 구할 수 있다.  
이를 이용해 데이터 값이 찍혀있는 점들로부터 오차가 가장 작은 일차 함수를 구할 수 있다.  
a, b 값을 구하는 공식은 아래와 같다.  
![](https://camo.githubusercontent.com/0556819ce12a57f18ac46e8c47136714608b6b18b8b1336877c42c956f87325e/68747470733a2f2f696d67312e6461756d63646e2e6e65742f7468756d622f523132383078302f3f73636f64653d6d746973746f72793226666e616d653d6874747073253341253246253246626c6f672e6b616b616f63646e2e6e6574253246646e25324642315443302532466274713041326a317767342532464175684c50454b49486b47634732353666386147756b253246696d672e706e67)  
`b = y의 평균 - (x의 평균 * 기울기 a)`  
  
  
# Review  
이번에 수업시간에 다루고 과제를 진행하면서 유전 알고리즘에 대해 더 공부하고 찾아보는데 처음에는 이해가 잘 가지 않았지만 개념을 계속 되새기고 후보해를 `gene[]`이라는 배열에 넣고 선택 교차 돌연변이 하는 과정을 직접 코딩해보니 개념이 이해되었다.  
기본적인 GA 알고리즘을 구현한 후 과제 내용을 수행하기 위해 데이터 조사로 아기의 성장과정을 0~12개월까지 키 변화를 조사하였고 이 데이터 집합들을 가장 잘 설명할 수 있는 회귀되는 일차 함수를 구하고자 하였다.  
여기서부터 문제점이 발생하였는데 오차가 가장 작은 회귀값을 구하기 위해서는 a, b값이 정수가 아닌 소수값으로 나타나야하는데 GA 알고리즘을 후보해를 0과 1로 `gene[]`배열로 구현하였고 적합도`fitness`을 `gene[]`배열을 2진수값으로 읽어낸 값으로 저장하여 사용하였기 때문에 정수값만 불러올 수 있는 문제가 발생하였다.  
하지만 이를 해결하기 위한 아이디어가 떠오르지 않아 그대로 적용하여 정수로 추정하기로 결심하고 진행하였다.  
또, 문제점으로 a, b 값을 모두 추정하는 과정이 잘 이루어지지 않았기에 위에 소개한 최소제곱법을 통해 조사한 데이터 집합들의 실제 회귀식을 구하여 실제 값과 추정 값을 비교하는 방식으로 진행하였다.  
위 과정에서 실제 b값은 그대로 사용하였고, a값은 b값을 이용하여 추정하였다.  
위 과정을 통해 회귀식 y=ax+b를 구하였고 b값은 실제 값을 사용하였으니 오차 값을 확인하지 않았고, a값의 경우에는 추정 a값과 실제 a값의 차를 구하여 얼마나 오차가 있는지 출력하여 추정된 a 값이 적절한지 검증하였다.  
GA 알고리즘의 경우 해 탐색 알고리즘으로 적절한 후보해를 찾을 경우 종료하여야 하는데 적절한 후보해를 판별하는 기준을 실제 a값은 소수값이고 추정 a값은 정수값이기 때문에 실제 a값과 추정 a값의 최소 오차 error범위는 -0.5<error<=0.5일 것이기 때문에 두 값의 차의 절대값이 0.5보다 작을 경우 종료하게 구현하였다.
돌연변이 연산의 경우 확률이 0% ~ 100%까지 어떻게 변하는지 돌려보며 확인하였는데 변화를 눈으로 확인하고싶어 표로 간단하게 정리해보았다.  
![](https://user-images.githubusercontent.com/101320758/174043567-34aa1a49-ec1e-41e1-a837-13fd1d4b69db.png)  
표롤 보면 돌연변이 확률이 70%일때 가장 적은 세대 수 안에 최적해를 찾았는데 70%을때를 보면 세대 수 편차가 심한거 같아 밑에 분산도 구하여 확인해 보았더니 분산은 확률이 50%일때 가장 적었다.  
물론 이것이 시도 횟수도 10회정도로 적은 횟수기도해서 정확한 자료라고는 할 수 없지만 이 표를 보면서 느낀점은 돌연변이 확률이 클수록 분산이 엄청 크게 나타날줄 알았는데 그렇진 않았다는 점이다.  
이 점에 대해서 생각해보고 나름 내린 결론은 현재 구현한 코드에서 후보해의 값을 나타내는 `gene[]`배열의 길이가 4밖에 안되어 돌연변이로 인해 빠르게 찾아질 수도 있다는게 생각한 결과이다.  
이 과제를 해결하면서 크게 느낀 점은 위에 말했듯이 잘 이해되지 않는 내용이여도 포기하기보다는 간단하게 개념을 정리한 후 직접 실습을 해보면서 부딪혀보는게 더 빠르게 이해하고 와닿을수도 있다는 점이고 이 점을 토대로 앞으로 어렵다 느끼는 내용도 천천히 해보기로 결심하였다.
