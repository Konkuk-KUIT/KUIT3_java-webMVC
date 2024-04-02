<!doctype html>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>KUIT</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/styles.css" rel="stylesheet">
  </head>
  <body>
    <nav class="navbar navbar-expand-md navbar-dark bg-dark" aria-label="Fourth navbar example">
      <div class="container-fluid">
        <a class="navbar-brand" href="/"> KUIT </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarsExample04" aria-controls="navbarsExample04" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
  
        <div class="collapse navbar-collapse" id="navbarsExample04">
          <ul class="navbar-nav me-auto mb-2 mb-md-0">
            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="#" id="dropdown04" data-bs-toggle="dropdown" aria-expanded="false">Home</a>
              <ul class="dropdown-menu" aria-labelledby="dropdown04">
                <li><a class="dropdown-item" href="#">Profile</a></li>
                <li><a class="dropdown-item" href="#">Settings</a></li>
              </ul>
            </li>
          </ul>
          <form>
            <input class="form-control" type="text" placeholder="Search" aria-label="Search">
          </form>
        </div>
      </div>
    </nav>
    <div class="navbar-default">
        <header class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3 mb-4 border-bottom">
            <a href="/" class="d-flex align-items-center col-md-3 mb-2 mb-md-0 text-dark text-decoration-none">
                <svg class="bi me-2" width="40" height="32" role="img" aria-label="Bootstrap"><use xlink:href="#bootstrap"/></svg>
            </a>

            <ul class="nav col-12 col-md-auto mb-2 justify-content-center mb-md-0">
                <li><a href="/index.html" class="nav-link px-2 link-secondary">Q&A</a></li>
                <li><a href="#" class="nav-link px-2 link-dark">FAQs</a></li>
                <li><a href="/user/userList" class="nav-link px-2 link-dark">User List</a></li>
                <li><a href="#" class="nav-link px-2 link-dark">About</a></li>
            </ul>

            <div class="col-md-3 text-end">
                <a href="/user/login.html" type="button" class="btn btn-outline-primary me-2">Login</a>
                <a href="/user/form.html" type="button" class="btn btn-primary">Sign-up</a>
            </div>
        </header>
    </div>

    <div class="container" id="main">
            <header class="qna-header">
                <h2 class="qna-title">객체지향에서 가장 중요하다고 생각하는 것이 무엇인가요?</h2>
            </header>
            <div class="content-main">
                <article class="article">
                    <div class="article-header">
                        <div class="article-header-thumb">
                            <img src="../img/picture.jpeg" class="article-author-thumb" alt="">
                        </div>
                        <div class="article-header-text">
                          <!-- 사용자 프로필 추가 할거면 span -> a 태그로 바꾸고 API 연결 -->
                            <span class="article-author-name">강지윤</span>
                            <span class="article-header-time">
                              2024-03-24 02:00
                            </span>
                        </div>
                    </div>
                    <div class="article-doc">
                        <p>객체지향의 특징 4가지</p>
                        <p>추상화</p>
                        <p>캡슐화</p>
                        <p>상속</p>
                        <p>다형성</p>
                        <p> ??? </p>
                    </div>
                    <div class="article-util">
                        <ul class="article-util-list">
                            <li>
                              <!-- 수정, 삭제 API 연결 필요 -->
                                <a class="link-modify-article" href="/questions/423/form">수정</a>
                            </li>
                            <li>
                              <!-- 수정, 삭제 API 연결 필요 -->
                                <form class="form-delete" action="/questions/423" method="POST">
                                    <input type="hidden" name="_method" value="DELETE">
                                    <button class="link-delete-article" type="submit">삭제</button>
                                </form>
                            </li>
                            <li>
                                <a class="link-modify-article" href="../home.jsp">목록</a>
                            </li>
                        </ul>
                    </div>
                </article>
  
                <div class="qna-comment">
                    <div class="qna-comment-kuit">
                        <p class="qna-comment-count"><strong>2</strong>개의 의견</p>
                        <div>
                            <article class="article" id="answer-1405">
                                <div class="article-header">
                                    <div class="article-header-thumb">
                                        <img src="../img/picture.jpeg" class="article-author-thumb" alt="">
                                    </div>
                                    <div class="article-header-text">
                                        <span class="article-author-name">김정우</span>
                                        <span class="article-header-time">
                                           2024-03-24 02:03
                                        </span>
                                    </div>
                                </div>
                                <div class="article-doc comment-doc">
                                    <p>장단점은 뭐라고 생각하세요?</p>
                                </div>
                                <div class="article-util">
                                    <ul class="article-util-list">
                                        <li>
                                          <!-- 수정, 삭제 API 연결 필요 -->
                                            <a class="link-modify-article" href="/questions/1/answers/1/form">수정</a>
                                        </li>
                                        <li>
                                          <!-- 수정, 삭제 API 연결 필요 -->
                                            <form class="delete-answer-form" action="/questions/1/answers/1" method="POST">
                                                <input type="hidden" name="_method" value="DELETE">
                                                <button type="submit" class="delete-answer-button">삭제</button>
                                            </form>
                                        </li>
                                    </ul>
                                </div>
                            </article>
                            <article class="article" id="answer-1406">
                                <div class="article-header">
                                    <div class="article-header-thumb">
                                        <img src="../img/picture.jpeg" class="article-author-thumb" alt="">
                                    </div>
                                    <div class="article-header-text">
                                        <span class="article-author-name">강지윤</span>
                                        <span class="article-header-time">
                                          2024-03-24 02:10
                                        </span>
                                    </div>
                                </div>
                                <div class="article-doc comment-doc">
                                    <p>뭐..어쩌고저쩌고...</p>
                                </div>
                                <div class="article-util">
                                    <ul class="article-util-list">
                                        <li>
                                          <!-- 수정, 삭제 API 연결 필요 -->
                                            <a class="link-modify-article" href="/questions/1/answers/2/form">수정</a>
                                        </li>
                                        <li>
                                          <!-- 수정, 삭제 API 연결 필요 -->
                                            <form class="form-delete" action="/questions/1/answers/2" method="POST">
                                                <input type="hidden" name="_method" value="DELETE">
                                                <button type="submit" class="delete-answer-button">삭제</button>
                                            </form>
                                        </li>
                                    </ul>
                                </div>
                            </article>
                            <form class="submit-write">
                                <div class="form-group" style="padding:14px;">
                                    <textarea class="form-control" placeholder="Update your status"></textarea>
                                </div>
                                <button class="btn btn-primary pull-right" type="button">답변하기</button>
                                <div class="clearfix" />
                            </form>
                        </div>
                    </div>
                </div>
            </div>
          </div>
      </div>
    </div>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
    <script src="../js/scripts.js"></script>
  </body>
</html>