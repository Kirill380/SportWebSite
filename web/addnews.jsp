<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Создание новсти</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    
    <link rel="stylesheet" type="text/css" href="css/style.css">

  </head>
  <body>
      <div class="container header">
        <div class="row">
          <div class="navbar navbar-inverse navbar-fixed-top">
            <div class="container">
              <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#responsive-menu">
                <span class="sr-only">Открыть навигацию</span>
                  <span class="icon-bar"></span>
                  <span class="icon-bar"></span>
                  <span class="icon-bar"></span>
                </button>
              </div>
              
              <div class="collapse navbar-collapse" id="responsive-menu">
                <ul class="nav navbar-nav">
                  <li><a href="#">Главная</a></li>
                  <li><a href="#">Бесплатная тренировка</a></li>
                  <li><a href="#">Расписание</a></li>
                  <li class="dropdown">
                  <a href="#" class="dropdown-toggle" data-toggle="dropdown">Секции <b class="caret"></b></a>
                  <ul class="dropdown-menu">
                    <li><a href="#">Тренажерный зал</a></li>
                    <li><a href="#">Рукопашный бой</a></li>
                    <li><a href="#">Бассейн</a></li>
                  </ul>
                  </li>
                  <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Дополнительные услуги <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                      <li><a href="#">Спа</a></li>
                    </ul>
                  </li>
                  <li class="dropdown">
                  <a href="#" class="dropdown-toggle" data-toggle="dropdown">О нас <b class="caret"></b></a>
                  <ul class="dropdown-menu">
                    <li><a href="#">История</a></li>
                    <li><a href="#">Вакансии</a></li>
                    <li><a href="#">Тренера</a></li>
                  </ul>
                  </li>
                    <li><a href="#">Контакты</a></li>
                  <li><a href="#">Личный кабинет</a></li>
                </ul>
              </div>
            </div>
          </div>
        </div>
      </div>

      <div class="container content-add-news">
        <div class="row"><h1>Создание новости</h1></div>
        <div class="row">
          <form action="/NewsController" method="POST">
          <label for="head"><h3>Заголовок</h3></label><br>
          <input type="text" name="head" id="head" placeholder="Введите заголовок новости"><br>
          <label for="new-content"><h3>Содержимое</h3></label><br>
          <textarea id="new-content" placeholder="Введите содержимое новости"></textarea>
        </div>
        <div class="row btn-wrapper">
          <button type="button" class="btn btn-default" data-toggle="modal" data-target="#success-send">Создать новость</button>
        </div>
        </form>
      </div>

      <div class="modal fade" id="success-send">
        <div class="modal-dialog">
          <div class="modal-content">
            <div class="modal-header">
            <button class="close" type="button" data-dismiss="modal">
              &times;
            </button>
            <h4 class="modal-title">Отправка данных успешна</h4>

            </div>
            <div class="modal-body">
              <p>Данные успешно отправлены на сервер. Новость сохранена в базу данных и будет опубликована при следующем обновлении главной страницы</p>
            </div>
            <div class="modal-footer">
              <button class="btn btn-success" type="button" data-dismiss="modal">OK</button>
            </div>
          </div>
        </div>

      </div>
      
      <div class="container footer">
        <div class="row">
          <div class="col-lg-3">
            Skype: lalka
          </div>
          <div class="col-lg-1"></div>
          <div class="col-lg-4">
            Phone number: +380995555555
          </div>
          <div class="col-lg-1"></div>
          <div class="col-lg-3">mail: lalka@gmail.com</div>
        </div>
      </div>




    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="js/jquery-2.1.3.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>