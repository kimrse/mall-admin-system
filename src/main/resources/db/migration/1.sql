create table `tenant` (
                          `id_tenant` int not null auto_increment,
                          `first_name` varchar(25) not null,
    `last_name` varchar(25) not null,
    `middle_name` varchar(25) null,
    `email` varchar(20) null,
    `phone` varchar(15) not null,
    `is_debtor` boolean not null default false,
    primary key (`id_tenant`)
    );
create table `store` (
                         `id_store` int not null auto_increment,
                         `store_title` varchar(150) null,
    `store_type` varchar(150) null,
    `store_description` varchar(516) null,
    `square_area` int not null,
    `floor` int not null,
    `monthly_cost` decimal not null,
    `picture` varchar(150) null,
    `is_occupied` boolean not null default false,
    primary key(`id_store`)
    );
create table `promo` (
                         `id_promo` int not null auto_increment,
                         `promo_type` varchar(150) not null,
    `promo_description` varchar(1032) null,
    `budget` decimal not null,
    `results_details` varchar(1032) null,
    `results_coverage` int null,
    `start_date` date not null,
    `end_date` date,
    `is_active` boolean not null default true,
    primary key(`id_promo`)
    );
create table `vacancy` (
                           `id_vacancy` int not null auto_increment,
                           `id_store` int not null,
                           `vacancy_title` varchar(150) not null,
    `vacancy_description` varchar(1032) not null,
    `salary` decimal,
    `is_active` boolean not null default true,
    primary key(`id_vacancy`),
    foreign key(`id_store`) references `store` (`id_store`)
    on delete cascade
    );
create table `employee` (
                            `id_employee` int not null auto_increment,
                            `id_store` int not null,
                            `first_name` varchar(25) not null,
    `last_name` varchar(25) not null,
    `middle_name` varchar(25) null,
    `job_title` varchar(150) not null,
    `hire_date` date not null,
    `monthly_salary` decimal null,
    `phone` varchar(15),
    primary key(`id_employee`),
    foreign key(`id_store`) references `store` (`id_store`)
    on delete cascade
    );
create table `storage` (
                           `id_storage` int not null auto_increment,
                           `id_store` int not null,
                           `product_name` varchar(150) not null,
    `supplier` varchar(150) not null,
    `manufacturer_country` varchar(150) not null,
    `amount` varchar(50) not null,
    `cost_per_day` decimal not null,
    `arrival_date` datetime not null,
    `delivery_date` datetime null,
    `is_delivered` boolean not null default false,
    primary key(`id_storage`),
    foreign key(`id_store`) references `store` (`id_store`)
    on delete cascade
    );
create table `contract` (
                            `id_contract` int not null auto_increment,
                            `id_tenant` int not null,
                            `id_store` int not null,
                            `details` varchar(1032) not null,
    `signed_date` date not null,
    `end_date` date not null,
    `is_active` boolean not null default true,
    `is_overdue` boolean not null default false,
    primary key(`id_contract`),
    foreign key(`id_tenant`) references `tenant` (`id_tenant`)
    on delete cascade,
    foreign key(`id_store`) references `store` (`id_store`)
    on delete cascade
    );
create table `invoice` (
                           `id_invoice` int not null auto_increment,
                           `id_contract` int not null,
                           `fee` int null,
                           `tax` int null,
                           `total_cost` decimal null,
                           `due_date` date not null,
                           `paid_date` date null,
                           `is_paid` boolean not null default false,
                           primary key(`id_invoice`),
    foreign key(`id_contract`) references `contract` (`id_contract`)
    on delete cascade
    );
create table `store_promo` (
                               `id` int not null auto_increment,
                               `id_store` int not null,
                               `id_promo` int not null,
                               primary key (`id`),
    foreign key(`id_store`) references `store` (`id_store`)
    on delete cascade,
    foreign key(`id_promo`) references `promo` (`id_promo`)
    on delete cascade
    );

--

insert into `tenant` (`first_name`, `last_name`, `middle_name`, `email`, `phone`)
values ('Алла', 'Аронова', 'Валентиновна', 'alla1639@yandex.ru', '+79419382837');

insert into `store` (`store_title`, `store_type`, `store_description`, `square_area`, `floor`, `monthly_cost`)
values ('Дарwell ', 'Сеть салонов бизнес-подарков', 'Подарки для тех, кому хочется подарить что-то особенное.
Деловые атрибуты, которые подчеркивают статус', 19, 1, 87800);

insert into `contract` (`id_tenant`, `id_store`, `details`, `signed_date`, `end_date`)
values (1, 1, 'Подробная информация о договоре', curdate(), '2024-07-15');

select `first_name`, `last_name`, `middle_name`, `phone`, `store_title`,
       `store_type`, `square_area`, `monthly_cost`, `details`, `signed_date`, `end_date`
from `contract`
    left join `tenant` using (`id_tenant`)
    left join `store` using (`id_store`)
where `first_name` = 'Алла' and `last_name` = 'Аронова';

--

insert into `invoice` (`id_contract`, `tax`, `due_date`, `paid_date`, `is_paid`)
values (1, 13, '2023-08-14',  '2023-', 1);

-- insert into `invoice` (`id_contract`, `tax`, `due_date`)
-- values (1, 13, '2023-08-14');

update `invoice`
    left join `contract` using (`id_contract`)
set `is_paid` = 1, `paid_date` = curdate(), `total_cost` = 87800
    where `id_contract` = 1;

select `first_name`, `last_name`, `middle_name`, `id_contract`, `store_title`,
       `total_cost`, `tax`, `fee`, `monthly_cost`, `paid_date`
from `invoice`
    left join `contract` using (`id_contract`)
    left join `tenant` using (`id_tenant`)
    left join `store` using (`id_store`)
where `id_invoice` = 1;

-- insert into `vacancy` (`id_store`, `vacancy_title`, `vacancy_description`, `salary`)
-- values (1, 'Продавец-консультант', 'Описание вакансии', 35000);

insert into `employee` (`id_store`, `first_name`, `last_name`, `middle_name`,
                        `job_title`, `hire_date`, `monthly_salary`, `phone`)
values (1, 'Дмитрий', 'Звягин', 'Максим', 'Юрьевич', curdate(), 35000, '+79398663623');

update `vacancy`
set `is_active` = false
    where `id_vacancy` = 1;

select `first_name`, `last_name`, `middle_name`, `job_title`, `hire_date`,
       `monthly_salary`, `vacancy_description`, `phone`
from `vacancy`
    left join `store` using (`id_store`)
    left join `employee` using (`id_store`)
where `id_employee` = 1;


insert into `storage` (`id_store`, `product_name`, `supplier`, `manufacturer_country`, `amount`,
                       `cost_per_day`, `arrival_date`)
values (1, 'Партия подарков', 'ОАО Подарочек', 'Китай', '4 коробки', 460, curdate());

update `storage`
set `delivery_date` = curdate(), `is_delivered` = true
    where `id_storage` = 1;

select `store_title`, `id_storage`, `product_name`, `supplier`, `manufacturer_country`, `amount`,
       `cost_per_day`, `arrival_date`, `delivery_date`
from `storage`
    left join `store` using (`id_store`)
where `id_storage` = 1 and `is_delivered` = true;

start transaction;
insert into `promo` (`promo_type`, `promo_description`, `budget`, `start_date`)
values ('Здесь расположен тип акции', 'Здесь расположено  подробноеописание акции', 300000, curdate());
set @promo_key = LAST_INSERT_ID();
insert into `store_promo` (`id_promo`, `id_store`)
values (@promo_key, 1);
commit;

update `promo`
set `results_details` = 'Подробное описание результатов проведенной акции',
    `results_coverage` = 1583, `end_date` = curdate(), `is_active` = false
    where `id_promo` = 1;

select `store_title`, `floor`, `promo_type`, `promo_description`, `budget`, `start_date`,
       `results_coverage`, `start_date`, `end_date`
from store_promo
         join store using (id_store)
         join promo using (id_promo)
where id_store = 1;







