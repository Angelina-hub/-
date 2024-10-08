from django.urls import path
from . import views

urlpatterns = [
    # Прямоугольник
    path('rectangle/<int:width>/<int:height>', views.get_rectangle_area),
    # Квадрат
    path('square/<int:side>', views.get_square_area),
    # Круг
    path('circle/<int:radius>', views.get_circle_area),
]
