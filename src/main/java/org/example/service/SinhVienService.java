package org.example.service;

import org.example.entity.SinhVien;

import java.util.ArrayList;
import java.util.List;

public class SinhVienService {
    List<SinhVien> sinhVienList = new ArrayList<>();
    public SinhVien update(SinhVien sinhVien) {
        if (sinhVien == null) {
            throw new IllegalArgumentException("sinh vien k dc null");
        }
        if (sinhVien.getTenSV() == null || sinhVien.getTenSV().trim().isEmpty()) {
            throw new IllegalArgumentException(" ten sinh vien k dc trong");
        }
        if (sinhVien.getChuyenNganh() == null || sinhVien.getChuyenNganh().trim().isEmpty()) {
            throw new IllegalArgumentException(" chuyen nganh sinh vien k dc trong");
        }
        if (sinhVien.getTuoi() <0) {
            throw new IllegalArgumentException("tuoi k dc <0");
        }
        if (sinhVien.getDiemTrungBinh() <0) {
            throw new IllegalArgumentException("diem tb tu 0-10");
        }
        if (sinhVien.getKyHoc() <0) {
            throw new IllegalArgumentException("ky hoc k dc <0");
        }
        for (SinhVien s : sinhVienList) {
            if (s.getMaSV().equals(sinhVien.getMaSV())) {
                s.setTenSV(sinhVien.getTenSV());
                s.setTuoi(sinhVien.getTuoi());
                s.setDiemTrungBinh(sinhVien.getDiemTrungBinh());
                s.setKyHoc(sinhVien.getKyHoc());
                s.setChuyenNganh(sinhVien.getChuyenNganh());
                return s;
            }
        }
        throw new IllegalArgumentException("k tim thay sv");
    }
    public SinhVien getSinhVien(String maSV) {
        for (SinhVien s : sinhVienList) {
            if (s.getMaSV().equals(maSV)) {
                return s;
            }
        }
        return null;
    }
    public void addSinhVien(SinhVien sinhVien) {
        sinhVienList.add(sinhVien);
    }
}
