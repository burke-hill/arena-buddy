import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Player } from './player';
import { PlayerService } from './player.service';
import { Chart, registerables } from 'chart.js';
Chart.register(...registerables);
import { ViewChild } from '@angular/core';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  chart = [];

  public players: Player[] = [];

  constructor(private playerService: PlayerService) { }

  ngOnInit(): void {
      this.getPlayers();
      this.RenderChart();
  }

  public getPlayers(): void {
    this.playerService.getPlayers().subscribe(
      (response: Player[]) => {
        this.players = response;
        console.log(this.players);
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
        labels: ['Druid', 'Blue', 'Yellow', 'Green', 'Purple', 'Orange'],
        datasets: [{
          label: '# of Votes',
          data: this.players,
          borderWidth: 1
        }]
      },
      options: {
        scales: {
          y: {
            beginAtZero: true
          }
        }
      }
    });

  }


}





