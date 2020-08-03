create table LESSON
(
    LESSON_ID   BIGINT auto_increment
        primary key,
    LESSON_NAME VARCHAR(255)
);

create table STUDENT
(
    STUDENT_ID BIGINT auto_increment
        primary key,
    STUDENT_NAME VARCHAR(255),
    STUDENT_SURNAME VARCHAR(255),
    STUDENT_AGE VARCHAR(255),
    STUDENT_ENTER_SYSTEM_DATE DATE
);

create table STUDENT_LESSON
(
    LESSON_ID BIGINT not null,
    STUDENT_ID BIGINT not null,
    primary key (LESSON_ID, STUDENT_ID),
    constraint FK2NMXS05VGK43XY1CKO182P72P
        foreign key (STUDENT_ID) references STUDENT (STUDENT_ID),
    constraint FKA64MWRI6GQ3AI7JWIH91GSMF7
        foreign key (LESSON_ID) references LESSON (LESSON_ID)
);




