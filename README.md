# Open Feign Demo

## Usage

### Importing Postman data: 포스트맨 데이터 추가
1. Run Postman.

   [Download Postman](https://www.postman.com/downloads/)

   포스트맨 실행.

2. Select Import in the left navigation menu.

   왼쪽 네비게이션 메뉴에서 Import 버튼을 클릭.
3. Select `Sample Data.postman_collection.json`, or drag it into the Import modal.

   `Sample Data.postman_collection.json`파일을 선택하거나, Import 창에 드래그 앤 드롭.

### Creating mock server: Mock 서버 생성

1. Select Mock Servers in the sidebar, then select +.

   왼쪽 사이드바에 Mock Servers 클릭 후 +(create mock server) 클릭. 만약 보이지 않으면 사이드바 가장 아래 Configure workspace sidebar 버튼을 클릭해 Mock Servers 메뉴를 활성화 해주세요.
2. Select an existing collection. Select `Sample Data` collection.

   `Select an existing collection`버튼 클릭 후 `Sample Data` 컬랙션 선택.
3. Write a mock server name and create mock server.

   이름 작성 후 `Create Mock Server` 클릭.

### Set property: 프로퍼티 설정

1. Enter the host address of the mock server created above into `feign.client.sampleData.url`.

   위에서 생성한 mock server의 호스트 주소를 `feign.client.sampleData.url`에 입력.

### Run Tests: 테스트 실행
