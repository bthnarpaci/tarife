package ders4;

import java.util.Scanner;

public class hazirlik {

	public static void main(String[] args) {
		Scanner giris = new Scanner(System.in);
		System.out.println("Kişi Sayısını Giriniz :");
		int ks = giris.nextInt();
		String ad[] = new String[ks];
		int dk[] = new int[ks];
		int sms[] = new int[ks];
		byte gb[] = new byte[ks];
		double ftr[] = new double[ks];
		byte menu;

		for (int i = 0; i < ks; i++) {
			System.out.println("Kişinin İsmini Giriniz : ");
			ad[i] = giris.next();
			System.out.println("Kaç Dakika : ");
			dk[i] = giris.nextInt();
			System.out.println("Kaç Sms : ");
			sms[i] = giris.nextInt();
			System.out.println("Kaç GB Internet : ");
			gb[i] = giris.nextByte();
			ftr[i] = ((dk[i] * 0.7) + (sms[i] * 0.55) + (gb[i] * 15));
		}
		for (;;) {
			System.out.println("1-Listeleme\n2-İsim Arama\n3-Dakika,Sms,İnternet ve Fatura Ortalama"
					+ "\n4-En Küçük Fatura\n5-En Büyük Fatura\n6-Çıkış");
			menu = giris.nextByte();
			switch (menu) {
			case 1:
				for (int i = 0; i < ftr.length; i++) {
					System.out.println("Adı : " + ad[i]);
					System.out.println("Dakika : " + dk[i]);
					System.out.println("Sms : " + sms[i]);
					System.out.println("İnternet : " + gb[i] + "GB");
					System.out.println("Fatura : " + ftr[i] + "TL");
				}
				break;
			case 2:
				System.out.println("Aranacak adı giriniz : ");
				String arananAd = giris.next();
				for (int i = 0; i < ftr.length; i++) {
					if (arananAd.equalsIgnoreCase(ad[i])) {
						System.out.println("Dakika : " + dk[i]);
						System.out.println("Sms : " + sms[i]);
						System.out.println("İnternet : " + gb[i] + "GB");
						System.out.println("Fatura : " + ftr[i] + "TL");
					}
				}
				break;
			case 3:
				int dko = 0;
				for (int i = 0; i < ftr.length; i++) {
					dko += dk[i];
				}
				System.out.println("Toplam Dakika Ortalaması : " + (dko / ks));
				int smso = 0;
				for (int i = 0; i < ftr.length; i++) {
					smso += sms[i];
				}
				System.out.println("Toplam Sms Ortalaması : " + (smso / ks));
				int gbo = 0;
				for (int i = 0; i < ftr.length; i++) {
					gbo += gb[i];
				}
				System.out.println("Toplam İnternet Ortalaması : " + (gbo / ks) + "GB");
				int ftro = 0;
				for (int i = 0; i < ftr.length; i++) {
					ftro += ftr[i];
				}
				System.out.println("Fatura Ortalaması : " + (ftro / ks) + "TL");
				break;
			case 4:
				double enb = ftr[0];
				for (int i = 0; i < ks; i++) {
					if (ftr[i] > enb)
						enb = ftr[i];
				}
				System.out.println("En pahalı fatura : " + enb);
				for (int i = 0; i < ks; i++) {
					if (ftr[i] < enb) {
						System.out.println("Dakika : " + dk[i]);
						System.out.println("Sms : " + sms[i]);
						System.out.println("İnternet : " + gb[i] + "GB");
						System.out.println("Fatura : " + ftr[i] + "TL");
					}

				}
				break;
			case 5:
				double enk = ftr[0];
				for (int i = 0; i < ks; i++) {
					if (ftr[i] > enk)
						enb = ftr[i];
				}
				System.out.println("En ucuz fatura : " + enk);
				for (int i = 0; i < ks; i++) {
					if (ftr[i] < enk) {
						System.out.println("Dakika : " + dk[i]);
						System.out.println("Sms : " + sms[i]);
						System.out.println("İnternet : " + gb[i] + "GB");
						System.out.println("Fatura : " + ftr[i] + "TL");
					}

				}
				break;
			case 6:
				System.out.println("Program Bitti");
				giris.close();
				System.exit(0);
				break;
			default:
				System.out.println("Geçersiz seçenek! Lütfen tekrar deneyin.");
				break;
			}			
		}
	}
}
