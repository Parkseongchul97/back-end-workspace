package com.kh._interface.step2;

public class Tv implements RemoteControl {
	
	private int volume;

	@Override
	public void setVolume(int volume) {
		if(volume > RemoteControl.MAX_VOLUME) { // 최대 볼륨이 되면
			this.volume = RemoteControl.MAX_VOLUME; // 최대 볼륨값 대입(그이상으로 못들어가도록)
		}else if (volume < RemoteControl.MIN_VOLUM) {
			this.volume = RemoteControl.MIN_VOLUM;
		}else {
			this.volume = volume;
		}
		System.out.println("현재 Tv 볼륨 : " + this.volume);
	}

	@Override
	public void search(String url) {
		System.out.println(url + "을 검색합니다.");
	}

	@Override
	public void turnOn() {
		System.out.println("TV를 켭니다.");
	}

	@Override
	public void turnOff() {
		System.out.println("TV를 끕니다.");
	}
	

}
