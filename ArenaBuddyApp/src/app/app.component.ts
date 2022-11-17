import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Player } from './player';
import { PlayerService } from './player.service';
import { Chart, registerables, Colors } from 'chart.js';
Chart.register(...registerables);
import { ViewChild } from '@angular/core';
import { map } from 'rxjs';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  chart = [];

  public players: Player[] = [];
  public player_classes: String[] = [];
  public classMap = new Map();
  public averageRating = 0;
  public topClassNum = 0;
  public topClassName = "";

  constructor(private playerService: PlayerService) { }

  ngOnInit(): void {
      this.getPlayers();
  }

  public getPlayers(): void {
    this.playerService.getPlayers().subscribe(
      (response: Player[]) => {
        this.players = response;
        this.initClasses();
        console.log(this.classMap.get('Warrior'));
      },
      (error: HttpErrorResponse) => {
        console.log(error.message);
      }
    )
  }

  RenderChart() {


    const myChart = new Chart("barchart", {
      type: 'bar',
      data: {
        labels: ['Warrior', 'Paladin', 'Hunter', 'Rogue', 'Priest', 'Shaman', 'Mage', 'Warlock', 'Monk','Druid', 'Demon Hunter', 'Death Knight', 'Evoker'],
        datasets: [{
          label: '# of Votes',
          data: [this.classMap.get('Warrior'),this.classMap.get('Paladin'),this.classMap.get('Hunter'),this.classMap.get('Rogue'),this.classMap.get('Priest'),this.classMap.get('Shaman'),this.classMap.get('Mage'),this.classMap.get('Warlock'),this.classMap.get('Monk'),this.classMap.get('Druid'),this.classMap.get('Demon'),this.classMap.get('Death'), this.classMap.get('Evoker')],
          backgroundColor: [
            'rgba(198, 155, 109, 1)',
            'rgba(244, 140, 186, 1)',
            'rgba(170, 211, 114, 1)',
            'rgba(255, 244, 104, 1)',
            'rgba(255, 255, 255, 1)',
            'rgba(0, 112, 221, 1)',
            'rgba(63, 199, 235, 1)',
            'rgba(135, 136, 238, 1)',
            'rgba(0, 255, 152, 1)',
            'rgba(255, 124, 10, 1)',
            'rgba(163, 48, 201, 1)',
            'rgba(196, 30, 58, 1)',
            'rgba(201, 203, 207, 1)'
          ],
          borderWidth: 1
        }],


      },
      options: {
        plugins: {
          legend: {
             display: false
          }
       },
        scales: {
          y: {
            beginAtZero: true
          }
        }
      }
    });

  }

  initClasses() {

    let tempMap = new Map();
    let curNum = 0;
    let i = 0;
    this.players.forEach((curClass) => {
      this.player_classes.push(curClass.player_wowclass);
      this.averageRating += curClass.player_rating;
    })

    this.player_classes.forEach((curIndex) => {
      if(!this.classMap.has(curIndex)) {
        this.classMap.set(curIndex,1);
      }
      else {
        curNum = this.classMap.get(curIndex);
        this.classMap.set(curIndex, curNum+=1);
        curNum = 0;
      }
    })
    this.averageRating /= 100;
    this.averageRating = Math.floor(this.averageRating);
    this.classMap.forEach((i) => {
      if(i > this.topClassNum) {
        this.topClassNum = i;
      }
    })

    console.log(Array.from(this.classMap.keys()));

    this.RenderChart();
    }




}










