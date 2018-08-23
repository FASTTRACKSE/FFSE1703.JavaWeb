package bean;
	
	public class GiangVienSE implements GiangVien{
		private String hoTenGv;
		private String emailGv;
		public GiangVienSE(String hoTenGv, String emailGv) {
			this.hoTenGv = hoTenGv;
			this.emailGv = emailGv;	
		}
		
		public String tenGiangVien() {
			
			return hoTenGv+" - "+emailGv+"\n";
	}

}
