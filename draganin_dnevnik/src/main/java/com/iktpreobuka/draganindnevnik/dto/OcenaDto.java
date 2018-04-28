package com.iktpreobuka.draganindnevnik.dto;

public class OcenaDto {
	
	    private Integer ocena;
	    private Integer polugodiste;
	    private Boolean zakljucnaOcena;
	    private Integer idUcenik;
	    private Integer idPredmet;
		public Integer getOcena() {
			return ocena;
		}
		public void setOcena(Integer ocena) {
			this.ocena = ocena;
		}
		public Integer getPolugodiste() {
			return polugodiste;
		}
		public void setPolugodiste(Integer polugodiste) {
			this.polugodiste = polugodiste;
		}
		public Boolean getZakljucnaOcena() {
			return zakljucnaOcena;
		}
		public void setZakljucnaOcena(Boolean zakljucnaOcena) {
			this.zakljucnaOcena = zakljucnaOcena;
		}
		public Integer getIdUcenik() {
			return idUcenik;
		}
		public void setIdUcenik(Integer idUcenik) {
			this.idUcenik = idUcenik;
		}
		public Integer getIdPredmet() {
			return idPredmet;
		}
		public void setIdPredmet(Integer idPredmet) {
			this.idPredmet = idPredmet;
		}
		public OcenaDto(Integer ocena, Integer polugodiste, Boolean zakljucnaOcena, Integer idUcenik,
				Integer idPredmet) {
			super();
			this.ocena = ocena;
			this.polugodiste = polugodiste;
			this.zakljucnaOcena = zakljucnaOcena;
			this.idUcenik = idUcenik;
			this.idPredmet = idPredmet;
		}
		public OcenaDto() {
			super();
			// TODO Auto-generated constructor stub
		}
	   

}
