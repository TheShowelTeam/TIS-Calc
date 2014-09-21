package com.Tol_V.tiscalc;

import java.util.ArrayList;

public class NodesTree {
    private static NodesTree instance;
    public static NodesTree getInstance() {
        if (instance == null){
            instance = new NodesTree();
        }

        return instance;
    }

    private final Category root;
    private Category current;

    {
        root = new Category(null, "Root", null, NodeType.CATEGORY);
    }

    private NodesTree() {
        current = root;
        //fillTree();
        Mega_shit();
    }


    private void fillTree(){
        Node level1Cat1 = new Category("level1Cat1", null, NodeType.CATEGORY);
        Node level1Cat2 = new Category("level1Cat2", null, NodeType.CATEGORY);

        Node level1Item1 = new Item("level1Item1", null, NodeType.ITEM, 11);
        Node level2Cat1 = new Category("level2Cat1", null, NodeType.CATEGORY);
        Node level2Cat2 = new Category("level2Cat2", null, NodeType.CATEGORY);
        Node level2Cat3 = new Category("level2Cat3", null, NodeType.CATEGORY);

        Node level3Item1 = new Item("level3Item1", null, NodeType.ITEM, 31);
        Node level3Item2 = new Item("level3Item2", null, NodeType.ITEM, 32);
        Node level3Item3 = new Item("level3Item3", null, NodeType.ITEM, 33);
        Node level3Item4 = new Item("level3Item4", null, NodeType.ITEM, 34);

        addChildren(level1Cat1);

        setCurrent((Category)level1Cat1);

        addChildren(level2Cat1);

        setCurrent((Category)level2Cat1);

        addChildren(level3Item1);

        setCurrentUp();
        setCurrentUp();

        addChildren(level1Cat2);

        setCurrent((Category)level1Cat2);

        addChildren(level2Cat2);

        setCurrent((Category)level2Cat2);

        addChildren(level3Item2);
        addChildren(level3Item3);

        setCurrentUp();

        addChildren(level2Cat3);

        setCurrent((Category)level2Cat3);

        addChildren(level3Item4);

        setCurrentUp();
        setCurrentUp();

        addChildren(level1Item1);
    }


    private void Mega_shit()
    {
        // ВНЕШНИЕ КАТЕГОРИИ
        Node[] MainCategories = {
                new Category("Тепловое оборудование(+)", "", NodeType.CATEGORY),
                new Category("Барное/Фаст-Фуд(+)", "", NodeType.CATEGORY),
                new Category("Механическое оборудование(+)", "", NodeType.CATEGORY),
                new Category("Холодильное оборудование(+)", "", NodeType.CATEGORY),
                new Category("Производство мучных изделий(+)", "", NodeType.CATEGORY),
                new Category("Нейтральное оборудование(+)", "", NodeType.CATEGORY),
                new Category("Прачечное оборудование(+)", "", NodeType.CATEGORY),
                new Category("Весы и торговое оборудование(+)", "", NodeType.CATEGORY),
                new Category("Подсобный инвентарь(+)", "", NodeType.CATEGORY),
                new Category("Восточная кухня(+)", "", NodeType.CATEGORY),
        };

        for (int i = 0; i < MainCategories.length; i++)
        {
            addChildren(MainCategories[i]);
        }


        //-------ТЕПЛОВОЕ ОБОРУДОВАНИЕ-------
        setCurrent((Category)MainCategories[0]);

        //--ТЕПЛОВОЕ ОБОРУДОВАНИЕ
        //----ПЛИТЫ (items)
        Node CatCat0 = new Category("Плиты(+)", "", NodeType.CATEGORY);
        addChildren(CatCat0);
        Node[] ItemsCatCat0 = {
                new Item("Плиты электрические", "", NodeType.ITEM, 82040),
                new Item("Плиты газовые", "", NodeType.ITEM, 82040),
                new Item("Плиты индукционные / стеклокерамические (не встраиваемые)", "", NodeType.ITEM, 120400),
                new Item("Плиты индукционные / стеклокерамические (встраиваемые)", "", NodeType.ITEM, 158060)

        };
        setCurrent((Category)CatCat0);
        for (int i = 0; i < ItemsCatCat0.length; i++)
        {
            addChildren(ItemsCatCat0[i]);
        }
        setCurrentUp();

        //--ТЕПЛОВОЕ ОБОРУДОВАНИЕ (items)
        Node[] ItemsCategory0 = {
                new Item("СВЧ  микроволновки", "", NodeType.ITEM, 82040),
                new Item("Чафинг-диши /  подогреватели  блюд", "", NodeType.ITEM, 45360),
                new Item("Коптильни мини", "", NodeType.ITEM, 60200),
                new Item("Тепловые столы / шкафы", "", NodeType.ITEM, 60200),
                new Item("Макароноварки", "", NodeType.ITEM, 82040),
                new Item("Кипятильники /  водонагреватели  проточные", "", NodeType.ITEM, 253820),
                new Item("Фритюры / жарочные  поверхности  (напольные)", "", NodeType.ITEM, 82040),
                new Item("Мармиты напольные", "", NodeType.ITEM, 82040),
                new Item("Сковороды электрическикие", "", NodeType.ITEM, 82040),
                new Item("Шкафы жарочные", "", NodeType.ITEM, 82040),
                new Item("Шкафы пекарские", "", NodeType.ITEM, 120400),
                new Item("Посудомойки фронтальные/стаканомоечные машины", "", NodeType.ITEM, 120400),
                new Item("Посудомойки  купольные (без монтажа подсобных столов)", "", NodeType.ITEM, 158060),
                new Item("Котлы  пищеварочные", "", NodeType.ITEM, 120400),
                new Item("Котлы  пищеварочные с миксером  и электронным  упралением", "", NodeType.ITEM, 158060),
                new Item("Пароконвектоматы  электрические", "", NodeType.ITEM, 158060),
                new Item("Пароконвектоматы  электрические программируемые", "", NodeType.ITEM, 253820),
                new Item("Коптильни производственные", "", NodeType.ITEM, 253820),
                new Item("Посудомойки  тоннельные ", "", NodeType.ITEM, 253820),

        };
        for (int i = 0; i < ItemsCategory0.length; i++)
        {
            addChildren(ItemsCategory0[i]);
        }
        setCurrentUp();

        //-------БАРНОЕ/ФАСТФУД(items)
        setCurrent((Category)MainCategories[1]);
        Node ItemsCategory1[] = {
                new Item("Аппараты  для  горячего  шоколада", "", NodeType.ITEM, 45360),
                new Item("Аппараты для хот-догов /  грили  роликовые", "", NodeType.ITEM, 91140),
                new Item("Барные холодильники", "", NodeType.ITEM, 120400),
                new Item("Блендеры /миксеры  для  коктейлей /соковыжималки", "", NodeType.ITEM, 158060),
                new Item("Блинницы /  вафельницы", "", NodeType.ITEM, 90300),
                new Item("Водонагреватели /кипятильники (заливные)", "", NodeType.ITEM, 45360),
                new Item("Водоумягчители ", "", NodeType.ITEM, 50120),
                new Item("Грили  для  кур", "", NodeType.ITEM, 60200),
                new Item("Грили Саламандра  (3 фазы)", "", NodeType.ITEM, 60200),
                new Item("Жарочные поверхности  настольные (3 фазы)", "", NodeType.ITEM, 60200),

                new Item("Измельчители  льда / кофемолки / кофеварки", "", NodeType.ITEM, 45360),
                new Item("Контактные грили / грили лавовые", "", NodeType.ITEM, 45360),
                new Item("Кофемашины  автоматические (офисные)", "", NodeType.ITEM, 67760),
                new Item("Кофемашины  полуавтоматические (рожковые) (без настройки)", "", NodeType.ITEM, 82040),
                new Item("Льдогенераторы  заливные до 15кг", "", NodeType.ITEM, 45360),
                new Item("Льдогенераторы  проточные до 50кг (с  подключением к  воде)", "", NodeType.ITEM, 60200),
                new Item("Пончиковые  аппараты", "", NodeType.ITEM, 45360),
                new Item("Попкорн", "", NodeType.ITEM, 70280),
                new Item("Сахарная  вата", "", NodeType.ITEM, 60200),
                new Item("Сокоохладители  и  граниторы", "", NodeType.ITEM, 82040),

                new Item("Тепловые витрины  настольные", "", NodeType.ITEM, 60200),
                new Item("Тостеры  и  мармиты  для  чипсов", "", NodeType.ITEM, 82040),
                new Item("Фритюрницы / чебуречницы  настольные", "", NodeType.ITEM, 82040),
                new Item("Холодильные витрины барные", "", NodeType.ITEM, 82040),
                new Item("Шаурма", "", NodeType.ITEM, 60200),
                new Item("Шашлычницы / мангалы", "", NodeType.ITEM, 70280),
                new Item("Шоколадные фонтаны", "", NodeType.ITEM, 82040)

        };
        for(int i = 0; i < ItemsCategory1.length; i++)
        {
            addChildren(ItemsCategory1[i]);
        }
        setCurrentUp();

        //Механическое оборудование(items)
        setCurrent((Category)MainCategories[2]);
        Node ItemsCategory2[] ={
                new Item("Слайсеры", "", NodeType.ITEM, 45360),
                new Item("прессы для мусора", "", NodeType.ITEM, 158060),
                new Item("Миксеры  ручные (гомогенизаторы)", "", NodeType.ITEM, 45360),
                new Item("Миксеры  планетарные  настольные", "", NodeType.ITEM, 60200),
                new Item("Шприцы  колбасные /  прессы для гамбургеров", "", NodeType.ITEM, 45360),
                new Item("Куттеры /  бликсеры", "", NodeType.ITEM, 60200),
                new Item("Процессоры  кухонные", "", NodeType.ITEM, 60200),
                new Item("Мясорыхлители (тендерайзеры)", "", NodeType.ITEM, 60200),
                new Item("Хлеборезки", "", NodeType.ITEM, 120400),
                new Item("Овощерезки / сыротерки", "", NodeType.ITEM, 82040),
                new Item("Мясорубки /  рыбочистки", "", NodeType.ITEM, 82040),
                new Item("Пилы  для  мяса", "", NodeType.ITEM, 60200),
                new Item("Фаршемешалки", "", NodeType.ITEM, 60200),
                new Item("Картофелечистки", "", NodeType.ITEM, 60200),
                new Item("Универсальные кухонные машины (УКМ ПК)", "", NodeType.ITEM, 82040),
                new Item("Котлетные аппараты", "", NodeType.ITEM, 1),
                new Item("Пельменные аппараты", "", NodeType.ITEM, 1)

        };
        for (int i = 0; i < ItemsCategory2.length; i++)
        {
            addChildren(ItemsCategory2[i]);
        }
        setCurrentUp();

        //--ХОЛОДИЛЬНОЕ ОБОРУДОВАНИЕ(items)
        setCurrent((Category)MainCategories[3]);
        Node ItemsCategory3[] = {
                new Item("Лари морозильные", "", NodeType.ITEM, 60200),
                new Item("Шкафы  холодильные / морозильные / универсальные", "", NodeType.ITEM, 50120),
                new Item("Столы  холодильные / морозильные / для  пиццы", "", NodeType.ITEM, 60200),
                new Item("Шкафы  кондитерские / медицинские", "", NodeType.ITEM, 60200),
                new Item("Витрины холодильные / морозильные / универсальные / кондитерские", "", NodeType.ITEM, 70280),
                new Item("Горки  гастрономические / фруктовые / универсальные", "", NodeType.ITEM, 70280),
                new Item("Ледогенераторы  чешуйчатые /  гранулированные", "", NodeType.ITEM, 82040),
                new Item("Моноблок", "", NodeType.ITEM, 70280),
                new Item("Сплит-Системы (трасса рассчитывается отдельно)", "", NodeType.ITEM, 82040),
                new Item("Конденсатор воздушного охлаждения", "", NodeType.ITEM, 50120),
                new Item("Воздухоохладитель", "", NodeType.ITEM, 70280),
                new Item("Центральная система холодоснабжения", "", NodeType.ITEM, 0),
                new Item("Камера  до  9м3 ", "", NodeType.ITEM, 28140),
                new Item("Камеры  до  20м3 ", "", NodeType.ITEM, 45360),
                new Item("Камеры  до  40м3 ", "", NodeType.ITEM, 45360),
                new Item("Камеры  до  60м3", "", NodeType.ITEM, 60200),
                new Item("Камеры для моргов /  специальные", "", NodeType.ITEM, 82040),

        };
        for (int i = 0; i < ItemsCategory3.length; i++)
        {
            addChildren(ItemsCategory3[i]);
        }
        setCurrentUp();

        //--ПРОИЗВОДСТВО МУЧНЫХ ИЗДЕЛИЙ (items)
        setCurrent((Category)MainCategories[4]);
        Node ItemsCategory4[] ={
                new Item("Прессы для  пиццы", "", NodeType.ITEM, 120400),
                new Item("Мукопросеиватели /  мельницы", "", NodeType.ITEM, 82040),
                new Item("Миксеры  планетарные  напольные до 30л.", "", NodeType.ITEM, 82040),
                new Item("Тестомесы  для  дрожжевого  теста до 50л.", "", NodeType.ITEM, 82040),
                new Item("Шкафы  расстойные для  конвекционных  печей", "", NodeType.ITEM, 82040),
                new Item("Аппарат  выпечки  оладьев, орешницы", "", NodeType.ITEM, 82040),
                new Item("Прибор  смешивания и дозировки воды", "", NodeType.ITEM, 120400),
                new Item("Тестомесы  для  крутого  теста  до 50л.", "", NodeType.ITEM, 82040),
                new Item("Печи  для  пиццы ", "", NodeType.ITEM, 158060),
                new Item("Печи  хлебопекарные подовые", "", NodeType.ITEM, 120400),

                new Item("Тестораскатки  напольные", "", NodeType.ITEM, 158060),
                new Item("Тестозакатки", "", NodeType.ITEM, 158060),
                new Item("Тестоделители / тестоокруглители", "", NodeType.ITEM, 82040),
                new Item("Печи  конвекционные промышленные", "", NodeType.ITEM, 253820),
                new Item("Аппараты отсадочные / дозировочные  (без настройки)", "", NodeType.ITEM, 0),
                new Item("Шкафы  расстойные для  роторных  печей", "", NodeType.ITEM, 253820),
                new Item("Печи  хлебопекарные ротационные", "", NodeType.ITEM, 315560),

        };
        for (int i = 0; i < ItemsCategory4.length; i++)
        {
            addChildren(ItemsCategory4[i]);
        }
        setCurrentUp();

        //--НЕЙТРАЛЬНОЕ ОБОРУДОВАНИЕ(items)
        setCurrent((Category)MainCategories[5]);
        Node ItemsCategory5[] ={
                new Item("Полки", "", NodeType.ITEM, 0),
                new Item("Подставки", "", NodeType.ITEM, 0),
                new Item("Столы,  стеллажи (сборные)", "", NodeType.ITEM, 0),
                new Item("Рукомойники", "", NodeType.ITEM, 0),
                new Item("Дополнительные модули к посудомоечной машине", "", NodeType.ITEM, 0),
                new Item("Стеллажи  шпильки / подставки для пароконвектоматов (разборные)", "", NodeType.ITEM, 0),
                new Item("Ванны  моечные 1-секц, котломойки (слив в  канализацию)", "", NodeType.ITEM, 0),
                new Item("Ванны моечные 2-х и 3-х секционные", "", NodeType.ITEM, 0),
                new Item("Смесители для ванн моечных", "", NodeType.ITEM, 0),
                new Item("Столы-тумбы,  шкафы для кухни (сборные)", "", NodeType.ITEM, 0),

                new Item("Транспортеры  дилной до 6 м", "", NodeType.ITEM, 120400),
                new Item("Транспортеры  дилной более 6 м", "", NodeType.ITEM, 158060),
                new Item("Вытяжные зонты пристенные (с монтажным  комплектом 1500р.)", "", NodeType.ITEM, 0),
                new Item("Вытяжные зонты островные (с  монтажным  комплектом  2500р.)", "", NodeType.ITEM, 0),
                new Item("Линия  разачи  нейтральный  элемент  (модуль / касса / стол)", "", NodeType.ITEM, 45360),
                new Item("Линия  разачи  (мармит / прилавок охлаждаемый / витрина)", "", NodeType.ITEM, 60200),

        };
        for (int i = 0; i < ItemsCategory5.length; i++)
        {
            addChildren(ItemsCategory5[i]);
        }
        setCurrentUp();

        //--ПРАЧЕЧНОЕ ОБОРУДОВАНИЕ(items)
        setCurrent((Category)MainCategories[6]);
        Node ItemsCategory6[] ={
                new Item("Стиральные машины бытовые", "", NodeType.ITEM, 60200),
                new Item("Стиральные машины промышленные до 8 кг", "", NodeType.ITEM, 82040),
                new Item("Стиральные машины промышленные до 30 кг", "", NodeType.ITEM, 158060),
                new Item("Стиральные машины промышленные свыше 30 кг", "", NodeType.ITEM, 253820),
                new Item("Сушильные барабаны до 10 кг", "", NodeType.ITEM, 120400),
                new Item("Сушильные барабаны свыше 10 кг", "", NodeType.ITEM, 158060),
                new Item("Гладильные катки", "", NodeType.ITEM, 158060),
                new Item("Гладильно - сушильные катки (каландры)", "", NodeType.ITEM, 253820),
                new Item("Гладильные прессы/пятновыводные столы", "", NodeType.ITEM, 158060),

        };
        for (int i = 0; i < ItemsCategory6.length; i++)
        {
            addChildren(ItemsCategory6[i]);
        }
        setCurrentUp();

        //--ВЕСЫ И ТОРГОВОЕ ОБОРУДОВАНИЕ(items)
        setCurrent((Category)MainCategories[7]);
        Node ItemsCategory7[] ={
                new Item("Весы  настольные / лабораторные", "", NodeType.ITEM, 28140),
                new Item("Весы  торговые / запайщики  пакетов / горячие  столы", "", NodeType.ITEM, 60200),
                new Item("Весы  напольные", "", NodeType.ITEM, 45360),
                new Item("Контейнеры и корзины распродаж", "", NodeType.ITEM, 0),
                new Item("Стеллажи  торговые (секция)", "", NodeType.ITEM, 0),
                new Item("Весы платформенные", "", NodeType.ITEM, 45360),
                new Item("Весы  крановые  и  автомобильные", "", NodeType.ITEM, 0),
                new Item("Вакуумные  упаковщики", "", NodeType.ITEM, 120400),
                new Item("Термоусадочные  машины", "", NodeType.ITEM, 120400),

        };
        for (int i = 0; i < ItemsCategory7.length; i++)
        {
            addChildren(ItemsCategory7[i]);
        }
        setCurrentUp();

        //--ВОСТОЧНАЯ КУХНЯ(items)
        setCurrent((Category)MainCategories[9]);
        Node ItemsCategory9[] ={
                new Item("Рисоварки", "", NodeType.ITEM, 45360),
                new Item("Термосы  для  риса", "", NodeType.ITEM, 45360),
                new Item("Ошиборницы (подогреватели полотенец)", "", NodeType.ITEM, 45360),
                new Item("Витрины  настольные  для  суши", "", NodeType.ITEM, 45360),
                new Item("Индукционные Wok  плиты (напольные)", "", NodeType.ITEM, 82040),
                new Item("Роботы  для  производства  суши  и  роллов", "", NodeType.ITEM, 253820),

        };
        for (int i = 0; i < ItemsCategory9.length; i++)
        {
            addChildren(ItemsCategory9[i]);
        }
        setCurrentUp();


    }

    private void addChildren(Node child){
        child.setParent(current);
        current.addChildren(child);
    }

    public boolean setCurrent(Category newCurrent){
        if (newCurrent != null && newCurrent.getParent() == current){
            current = newCurrent;
            return true;
        }
        return  false;
    }

    public boolean setCurrentUp(){
        if (current != root){
            current = (Category)current.getParent();
            return true;
        }
        return false;
    }

    public ArrayList<Node> getChildren(){
        return current.getChildren();
    }

    public String toString(){
        String msg = "Root: " + root + '\n';
        msg += "Current: " + current;

        ArrayList<Node> children = current.getChildren();

        for(Node tmp: children){
            msg += "\n----" + tmp;
        }

        return msg;
    }
}
