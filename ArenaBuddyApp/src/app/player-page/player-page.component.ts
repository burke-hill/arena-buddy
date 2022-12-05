import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PlayerService } from '../player.service';
import { Player } from '../player';
import { HttpErrorResponse } from '@angular/common/http';
@Component({
  selector: 'app-player-page',
  templateUrl: './player-page.component.html',
  styleUrls: ['./player-page.component.css']
})
export class PlayerPageComponent implements OnInit {

  public player: Player | undefined;

  constructor(private playerService: PlayerService) { }

  ngOnInit(): void {
    this.getPlayer
  }

  public getPlayer(playerName: String): void {
    this.playerService.getPlayer(playerName).subscribe(
      (response: Player) => {
        this.player = response;
      },
      (error: HttpErrorResponse) => {
        console.log(error.message);
      }
    )
  }
}
