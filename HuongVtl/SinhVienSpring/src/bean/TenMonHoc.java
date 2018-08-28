package bean;

public class TenMonHoc implements MonHoc{
		private String tenMonHoc;
		private String giangVien;
		public TenMonHoc(String tenMonHoc, String giangVien) {
			this.tenMonHoc = tenMonHoc;
			this.giangVien = giangVien;
		}
		
		@Override
		public String monHoc() {
			// TODO Auto-generated method stub
			return tenMonHoc;
		}

		@Override
		public String GiangVien() {
			// TODO Auto-generated method stub
			return giangVien;
		}

}
