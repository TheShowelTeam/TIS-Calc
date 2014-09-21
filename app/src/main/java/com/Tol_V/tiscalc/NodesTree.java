package com.Tol_V.tiscalc;

import org.json.JSONArray;

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
                new Category("Тепловое оборудование(+)", null, NodeType.CATEGORY),
                new Category("Барное/Фаст-Фуд(+)", null, NodeType.CATEGORY),
                new Category("Механическое оборудование(+)", null, NodeType.CATEGORY),
                new Category("Холодильное оборудование(+)", null, NodeType.CATEGORY),
                new Category("Производство мучных изделий(+)", null, NodeType.CATEGORY),
                new Category("Нейтральное оборудование(+)", null, NodeType.CATEGORY),
                new Category("Прачечное оборудование(+)", null, NodeType.CATEGORY),
                new Category("Весы и торговое оборудование(+)", null, NodeType.CATEGORY),
                new Category("Подсобный инвентарь(+)", null, NodeType.CATEGORY),
                new Category("Восточная кухня(+)", null, NodeType.CATEGORY),
        };

        for (int i = 0; i < MainCategories.length; i++)
        {
            addChildren(MainCategories[i]);
        }


        //-------ТЕПЛОВОЕ ОБОРУДОВАНИЕ-------
        setCurrent((Category)MainCategories[0]);

        //--ТЕПЛОВОЕ ОБОРУДОВАНИЕ
        //----ПЛИТЫ (items)
        Node CatCat0 = new Category("Плиты(+)", null, NodeType.CATEGORY);
        addChildren(CatCat0);
        Node[] ItemsCatCat0 = {
                new Item("Плиты электрические", null, NodeType.ITEM, 82040),
                new Item("Плиты газовые", null, NodeType.ITEM, 82040),
                new Item("Плиты индукционные / стеклокерамические (не встраиваемые)", null, NodeType.ITEM, 120400),
                new Item("Плиты индукционные / стеклокерамические (встраиваемые)", null, NodeType.ITEM, 158060)

        };
        setCurrent((Category)CatCat0);
        for (int i = 0; i < ItemsCatCat0.length; i++)
        {
            addChildren(ItemsCatCat0[i]);
        }
        setCurrentUp();

        //--ТЕПЛОВОЕ ОБОРУДОВАНИЕ (items)
        Node[] ItemsCategory0 = {
                new Item("СВЧ  микроволновки", null, NodeType.ITEM, 82040),
                new Item("Чафинг-диши /  подогреватели  блюд", null, NodeType.ITEM, 45360),
                new Item("Коптильни мини", null, NodeType.ITEM, 60200),
                new Item("Тепловые столы / шкафы", null, NodeType.ITEM, 60200),
                new Item("Макароноварки", null, NodeType.ITEM, 82040),
                new Item("Кипятильники /  водонагреватели  проточные", null, NodeType.ITEM, 253820),
                new Item("Фритюры / жарочные  поверхности  (напольные)", null, NodeType.ITEM, 82040),
                new Item("Мармиты напольные", null, NodeType.ITEM, 82040),
                new Item("Сковороды электрическикие", null, NodeType.ITEM, 82040),
                new Item("Шкафы жарочные", null, NodeType.ITEM, 82040),
                new Item("Шкафы пекарские", null, NodeType.ITEM, 120400),
                new Item("Посудомойки фронтальные/стаканомоечные машины", null, NodeType.ITEM, 120400),
                new Item("Посудомойки  купольные (без монтажа подсобных столов)", null, NodeType.ITEM, 158060),
                new Item("Котлы  пищеварочные", null, NodeType.ITEM, 120400),
                new Item("Котлы  пищеварочные с миксером  и электронным  упралением", null, NodeType.ITEM, 158060),
                new Item("Пароконвектоматы  электрические", null, NodeType.ITEM, 158060),
                new Item("Пароконвектоматы  электрические программируемые", null, NodeType.ITEM, 253820),
                new Item("Коптильни производственные", null, NodeType.ITEM, 253820),
                new Item("Посудомойки  тоннельные ", null, NodeType.ITEM, 253820),

        };
        for (int i = 0; i < ItemsCategory0.length; i++)
        {
            addChildren(ItemsCategory0[i]);
        }
        setCurrentUp();

        //-------БАРНОЕ/ФАСТФУД(items)
        setCurrent((Category)MainCategories[1]);
        Node ItemsCategory1[] = {
                new Item("Аппараты  для  горячего  шоколада", null, NodeType.ITEM, 45360),
                new Item("Аппараты для хот-догов /  грили  роликовые", null, NodeType.ITEM, 91140),
                new Item("Барные холодильники", null, NodeType.ITEM, 120400),
                new Item("Блендеры /миксеры  для  коктейлей /соковыжималки", null, NodeType.ITEM, 158060),
                new Item("Блинницы /  вафельницы", null, NodeType.ITEM, 90300),
                new Item("Водонагреватели /кипятильники (заливные)", null, NodeType.ITEM, 45360),
                new Item("Водоумягчители ", null, NodeType.ITEM, 50120),
                new Item("Грили  для  кур", null, NodeType.ITEM, 60200),
                new Item("Грили Саламандра  (3 фазы)", null, NodeType.ITEM, 60200),
                new Item("Жарочные поверхности  настольные (3 фазы)", null, NodeType.ITEM, 60200),

                new Item("Измельчители  льда / кофемолки / кофеварки", null, NodeType.ITEM, 45360),
                new Item("Контактные грили / грили лавовые", null, NodeType.ITEM, 45360),
                new Item("Кофемашины  автоматические (офисные)", null, NodeType.ITEM, 67760),
                new Item("Кофемашины  полуавтоматические (рожковые) (без настройки)", null, NodeType.ITEM, 82040),
                new Item("Льдогенераторы  заливные до 15кг", null, NodeType.ITEM, 45360),
                new Item("Льдогенераторы  проточные до 50кг (с  подключением к  воде)", null, NodeType.ITEM, 60200),
                new Item("Пончиковые  аппараты", null, NodeType.ITEM, 45360),
                new Item("Попкорн", null, NodeType.ITEM, 70280),
                new Item("Сахарная  вата", null, NodeType.ITEM, 60200),
                new Item("Сокоохладители  и  граниторы", null, NodeType.ITEM, 82040),

                new Item("Тепловые витрины  настольные", null, NodeType.ITEM, 60200),
                new Item("Тостеры  и  мармиты  для  чипсов", null, NodeType.ITEM, 82040),
                new Item("Фритюрницы / чебуречницы  настольные", null, NodeType.ITEM, 82040),
                new Item("Холодильные витрины барные", null, NodeType.ITEM, 82040),
                new Item("Шаурма", null, NodeType.ITEM, 60200),
                new Item("Шашлычницы / мангалы", null, NodeType.ITEM, 70280),
                new Item("Шоколадные фонтаны", null, NodeType.ITEM, 82040)

        };
        for(int i = 0; i < ItemsCategory1.length; i++)
        {
            addChildren(ItemsCategory1[i]);
        }
        setCurrentUp();

        //Механическое оборудование(items)
        setCurrent((Category)MainCategories[2]);
        Node ItemsCategory2[] ={
                new Item("Слайсеры", null, NodeType.ITEM, 45360),
                new Item("прессы для мусора", null, NodeType.ITEM, 158060),
                new Item("Миксеры  ручные (гомогенизаторы)", null, NodeType.ITEM, 45360),
                new Item("Миксеры  планетарные  настольные", null, NodeType.ITEM, 60200),
                new Item("Шприцы  колбасные /  прессы для гамбургеров", null, NodeType.ITEM, 45360),
                new Item("Куттеры /  бликсеры", null, NodeType.ITEM, 60200),
                new Item("Процессоры  кухонные", null, NodeType.ITEM, 60200),
                new Item("Мясорыхлители (тендерайзеры)", null, NodeType.ITEM, 60200),
                new Item("Хлеборезки", null, NodeType.ITEM, 120400),
                new Item("Овощерезки / сыротерки", null, NodeType.ITEM, 82040),
                new Item("Мясорубки /  рыбочистки", null, NodeType.ITEM, 82040),
                new Item("Пилы  для  мяса", null, NodeType.ITEM, 60200),
                new Item("Фаршемешалки", null, NodeType.ITEM, 60200),
                new Item("Картофелечистки", null, NodeType.ITEM, 60200),
                new Item("Универсальные кухонные машины (УКМ ПК)", null, NodeType.ITEM, 82040),
                new Item("Котлетные аппараты", null, NodeType.ITEM, 1),
                new Item("Пельменные аппараты", null, NodeType.ITEM, 1)

        };
        for (int i = 0; i < ItemsCategory2.length; i++)
        {
            addChildren(ItemsCategory2[i]);
        }
        setCurrentUp();

        //--ХОЛОДИЛЬНОЕ ОБОРУДОВАНИЕ(items)
        setCurrent((Category)MainCategories[3]);
        Node ItemsCategory3[] = {
                new Item("Лари морозильные", null, NodeType.ITEM, 60200),
                new Item("Шкафы  холодильные / морозильные / универсальные", null, NodeType.ITEM, 50120),
                new Item("Столы  холодильные / морозильные / для  пиццы", null, NodeType.ITEM, 60200),
                new Item("Шкафы  кондитерские / медицинские", null, NodeType.ITEM, 60200),
                new Item("Витрины холодильные / морозильные / универсальные / кондитерские", null, NodeType.ITEM, 70280),
                new Item("Горки  гастрономические / фруктовые / универсальные", null, NodeType.ITEM, 70280),
                new Item("Ледогенераторы  чешуйчатые /  гранулированные", null, NodeType.ITEM, 82040),
                new Item("Моноблок", null, NodeType.ITEM, 70280),
                new Item("Сплит-Системы (трасса рассчитывается отдельно)", null, NodeType.ITEM, 82040),
                new Item("Конденсатор воздушного охлаждения", null, NodeType.ITEM, 50120),
                new Item("Воздухоохладитель", null, NodeType.ITEM, 70280),
                new Item("Центральная система холодоснабжения", null, NodeType.ITEM, 0),
                new Item("Камера  до  9м3 ", null, NodeType.ITEM, 28140),
                new Item("Камеры  до  20м3 ", null, NodeType.ITEM, 45360),
                new Item("Камеры  до  40м3 ", null, NodeType.ITEM, 45360),
                new Item("Камеры  до  60м3", null, NodeType.ITEM, 60200),
                new Item("Камеры для моргов /  специальные", null, NodeType.ITEM, 82040),

        };
        for (int i = 0; i < ItemsCategory3.length; i++)
        {
            addChildren(ItemsCategory3[i]);
        }
        setCurrentUp();

        //--ПРОИЗВОДСТВО МУЧНЫХ ИЗДЕЛИЙ (items)
        setCurrent((Category)MainCategories[4]);
        Node ItemsCategory4[] ={
                new Item("Прессы для  пиццы", null, NodeType.ITEM, 120400),
                new Item("Мукопросеиватели /  мельницы", null, NodeType.ITEM, 82040),
                new Item("Миксеры  планетарные  напольные до 30л.", null, NodeType.ITEM, 82040),
                new Item("Тестомесы  для  дрожжевого  теста до 50л.", null, NodeType.ITEM, 82040),
                new Item("Шкафы  расстойные для  конвекционных  печей", null, NodeType.ITEM, 82040),
                new Item("Аппарат  выпечки  оладьев, орешницы", null, NodeType.ITEM, 82040),
                new Item("Прибор  смешивания и дозировки воды", null, NodeType.ITEM, 120400),
                new Item("Тестомесы  для  крутого  теста  до 50л.", null, NodeType.ITEM, 82040),
                new Item("Печи  для  пиццы ", null, NodeType.ITEM, 158060),
                new Item("Печи  хлебопекарные подовые", null, NodeType.ITEM, 120400),

                new Item("Тестораскатки  напольные", null, NodeType.ITEM, 158060),
                new Item("Тестозакатки", null, NodeType.ITEM, 158060),
                new Item("Тестоделители / тестоокруглители", null, NodeType.ITEM, 82040),
                new Item("Печи  конвекционные промышленные", null, NodeType.ITEM, 253820),
                new Item("Аппараты отсадочные / дозировочные  (без настройки)", null, NodeType.ITEM, 0),
                new Item("Шкафы  расстойные для  роторных  печей", null, NodeType.ITEM, 253820),
                new Item("Печи  хлебопекарные ротационные", null, NodeType.ITEM, 315560),

        };
        for (int i = 0; i < ItemsCategory4.length; i++)
        {
            addChildren(ItemsCategory4[i]);
        }
        setCurrentUp();

        //--НЕЙТРАЛЬНОЕ ОБОРУДОВАНИЕ(items)
        setCurrent((Category)MainCategories[5]);
        Node ItemsCategory5[] ={
                new Item("Полки", null, NodeType.ITEM, 0),
                new Item("Подставки", null, NodeType.ITEM, 0),
                new Item("Столы,  стеллажи (сборные)", null, NodeType.ITEM, 0),
                new Item("Рукомойники", null, NodeType.ITEM, 0),
                new Item("Дополнительные модули к посудомоечной машине", null, NodeType.ITEM, 0),
                new Item("Стеллажи  шпильки / подставки для пароконвектоматов (разборные)", null, NodeType.ITEM, 0),
                new Item("Ванны  моечные 1-секц, котломойки (слив в  канализацию)", null, NodeType.ITEM, 0),
                new Item("Ванны моечные 2-х и 3-х секционные", null, NodeType.ITEM, 0),
                new Item("Смесители для ванн моечных", null, NodeType.ITEM, 0),
                new Item("Столы-тумбы,  шкафы для кухни (сборные)", null, NodeType.ITEM, 0),

                new Item("Транспортеры  дилной до 6 м", null, NodeType.ITEM, 120400),
                new Item("Транспортеры  дилной более 6 м", null, NodeType.ITEM, 158060),
                new Item("Вытяжные зонты пристенные (с монтажным  комплектом 1500р.)", null, NodeType.ITEM, 0),
                new Item("Вытяжные зонты островные (с  монтажным  комплектом  2500р.)", null, NodeType.ITEM, 0),
                new Item("Линия  разачи  нейтральный  элемент  (модуль / касса / стол)", null, NodeType.ITEM, 45360),
                new Item("Линия  разачи  (мармит / прилавок охлаждаемый / витрина)", null, NodeType.ITEM, 60200),

        };
        for (int i = 0; i < ItemsCategory5.length; i++)
        {
            addChildren(ItemsCategory5[i]);
        }
        setCurrentUp();

        //--ПРАЧЕЧНОЕ ОБОРУДОВАНИЕ(items)
        setCurrent((Category)MainCategories[6]);
        Node ItemsCategory6[] ={
                new Item("Стиральные машины бытовые", null, NodeType.ITEM, 60200),
                new Item("Стиральные машины промышленные до 8 кг", null, NodeType.ITEM, 82040),
                new Item("Стиральные машины промышленные до 30 кг", null, NodeType.ITEM, 158060),
                new Item("Стиральные машины промышленные свыше 30 кг", null, NodeType.ITEM, 253820),
                new Item("Сушильные барабаны до 10 кг", null, NodeType.ITEM, 120400),
                new Item("Сушильные барабаны свыше 10 кг", null, NodeType.ITEM, 158060),
                new Item("Гладильные катки", null, NodeType.ITEM, 158060),
                new Item("Гладильно - сушильные катки (каландры)", null, NodeType.ITEM, 253820),
                new Item("Гладильные прессы/пятновыводные столы", null, NodeType.ITEM, 158060),

        };
        for (int i = 0; i < ItemsCategory6.length; i++)
        {
            addChildren(ItemsCategory6[i]);
        }
        setCurrentUp();

        //--ВЕСЫ И ТОРГОВОЕ ОБОРУДОВАНИЕ(items)
        setCurrent((Category)MainCategories[7]);
        Node ItemsCategory7[] ={
                new Item("Весы  настольные / лабораторные", null, NodeType.ITEM, 28140),
                new Item("Весы  торговые / запайщики  пакетов / горячие  столы", null, NodeType.ITEM, 60200),
                new Item("Весы  напольные", null, NodeType.ITEM, 45360),
                new Item("Контейнеры и корзины распродаж", null, NodeType.ITEM, 0),
                new Item("Стеллажи  торговые (секция)", null, NodeType.ITEM, 0),
                new Item("Весы платформенные", null, NodeType.ITEM, 45360),
                new Item("Весы  крановые  и  автомобильные", null, NodeType.ITEM, 0),
                new Item("Вакуумные  упаковщики", null, NodeType.ITEM, 120400),
                new Item("Термоусадочные  машины", null, NodeType.ITEM, 120400),

        };
        for (int i = 0; i < ItemsCategory7.length; i++)
        {
            addChildren(ItemsCategory7[i]);
        }
        setCurrentUp();

        //--ВОСТОЧНАЯ КУХНЯ(items)
        setCurrent((Category)MainCategories[9]);
        Node ItemsCategory9[] ={
                new Item("Рисоварки", null, NodeType.ITEM, 45360),
                new Item("Термосы  для  риса", null, NodeType.ITEM, 45360),
                new Item("Ошиборницы (подогреватели полотенец)", null, NodeType.ITEM, 45360),
                new Item("Витрины  настольные  для  суши", null, NodeType.ITEM, 45360),
                new Item("Индукционные Wok  плиты (напольные)", null, NodeType.ITEM, 82040),
                new Item("Роботы  для  производства  суши  и  роллов", null, NodeType.ITEM, 253820),

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
