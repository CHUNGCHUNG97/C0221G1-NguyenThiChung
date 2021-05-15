create database xuat_nhap_hang_hoa;
use xuat_nhap_hang_hoa;
create table nha_cc
(
    id_nha_cc  int primary key not null auto_increment,
    ten_nha_cc varchar(45),
    dia_chi    varchar(45),
    sdt        varchar(45)
);
create table vat_tu
(
    ma_vat_tu  int auto_increment primary key not null,
    ten_vat_tu varchar(45)
);
create table don_dat_hang
(
    id_don_dh int primary key auto_increment not null,
    ngay_dh   date,
    ma_vat_tu int,
    id_nha_cc int,
    foreign key (ma_vat_tu) references vat_tu (ma_vat_tu),
    foreign key (id_nha_cc) references nha_cc (id_nha_cc)
);
create table phieu_nhap
(
    so_phieu_nhap int auto_increment primary key not null,
    ngay_nhap     date
);
create table don_gia_nhap
(
    don_gia       float,
    so_luong      int,
    so_phieu_nhap int,
    ma_vat_tu     int,
    primary key (so_phieu_nhap, ma_vat_tu),
    foreign key (so_phieu_nhap) references phieu_nhap (so_phieu_nhap),
    foreign key (ma_vat_tu) references vat_tu (ma_vat_tu)
);
create table phieu_xuat
(
    so_phieu_xuat int primary key auto_increment not null,
    ngay_xuat     date
);
create table don_gia_xuat
(
    don_gia       float,
    so_luong      int,
    so_phieu_xuat int,
    ma_vat_tu     int,
    primary key (so_phieu_xuat, ma_vat_tu),
    foreign key (so_phieu_xuat) references phieu_xuat (so_phieu_xuat),
    foreign key (ma_vat_tu) references vat_tu (ma_vat_tu)
);
